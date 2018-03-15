package com.butterknife.compiler;

import com.butterknife.annotation.BinderView;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by 花歹 on 2018/3/14.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

@AutoService(Processor.class)
public class ButterKnifeProcessor extends AbstractProcessor {

    private Filer mFiler;
    private Elements mElementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnvironment.getFiler();
        mElementUtils = processingEnvironment.getElementUtils();
    }

    //指定处理的版本
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported(); //拿最高版本
    }


    //指定需要处理的注解

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : getSupportedAnnotations()) {
            types.add(annotation.getCanonicalName());
        }
        return types;
    }

    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        //需要解析的自定义注解
        annotations.add(BinderView.class);
        return annotations;
    }

    //
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        if (set != null && !set.isEmpty()) {
            //第一步先测试能不能运行到这
//            System.out.println("---------------------------------------->");
//            System.out.println("---------------------------------------->");
//            System.out.println("---------------------------------------->");
//            System.out.println("---------------------------------------->");

            //process 代表 有注解才会进来
            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BinderView.class);
            for (Element element : elements) {
                System.out.println("element:" + element.getSimpleName().toString()); //element 返回的是注解所在的变量或者方法或者类
                Element encloseingElement = element.getEnclosingElement();
                System.out.println("encloseingElement:" + encloseingElement.getSimpleName().toString());
            }

            //解析 属性activity -> List<Element>
            //在此处encloseingElement 代表的是activity
            //利用存储方式，每个activity中存储自己所持有的变量（有ViewBinder的变量）
            Map<Element, List<Element>> elementMap = new LinkedHashMap<>();
            for (Element element : elements) {
                Element encloseingElement = element.getEnclosingElement();
                List<Element> viewBinderElements = elementMap.get(encloseingElement);
                if (viewBinderElements ==null) {
                    viewBinderElements = new ArrayList<>();
                    elementMap.put(encloseingElement,viewBinderElements);
                }
                viewBinderElements.add(element);
            }
            //生成代码
            for (Map.Entry<Element, List<Element>> entry : elementMap.entrySet()) {
                Element encloseingElement = entry.getKey();
                List<Element> viewBinderElements = entry.getValue();

                ClassName unbindClassName = ClassName.get("com.butterknife","Unbinder");
                //获取activity 名字
                String activityClassNameStr = encloseingElement.getSimpleName().toString();

                //构建变量
                ClassName activityClassName = ClassName.bestGuess(activityClassNameStr);

                //构建unbinder方法
                ClassName callSuperClassName = ClassName.get("android.support.annotation","CallSuper");
                MethodSpec.Builder unbinderMethodBuilder = MethodSpec.methodBuilder("unbind")
                        .addModifiers(Modifier.PUBLIC,Modifier.FINAL)
                        .addAnnotation(Override.class)
                        .addAnnotation(callSuperClassName);
                unbinderMethodBuilder.addStatement("$T target = this.target;", activityClassName);
                unbinderMethodBuilder.addStatement("if (target == null) throw new IllegalStateException(\"Bindings already cleared\")");
                unbinderMethodBuilder.addStatement("this.target = null;");


                //构造函数
                MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
                        .addParameter(activityClassName,"target");//添加参数
                for (Element viewBinderElement : viewBinderElements) {
                    String fieldName = viewBinderElement.getSimpleName().toString();
                    ClassName utilsClassName = ClassName.get("com.demo.butterknifeframework","Utils");
                    int resId = viewBinderElement.getAnnotation(BinderView.class).value();
                    constructorBuilder.addStatement("target.$L = $T.findViewById(target,$L);",fieldName,utilsClassName,resId);


                    unbinderMethodBuilder.addStatement("target.$L = null",fieldName);
                }


                //构建activity 名字_ViewBinding 类
                TypeSpec.Builder classBuilder = TypeSpec
                        .classBuilder(activityClassNameStr+"_ViewBinding")
                        .addModifiers(Modifier.FINAL,Modifier.PUBLIC)//修饰类
                        .addSuperinterface(unbindClassName) //实现接口
                        .addMethod(unbinderMethodBuilder.build())//实现方法
                        .addMethod(constructorBuilder.build()) //构造方法
                        .addField(activityClassName,"target",Modifier.PRIVATE);   //添加变量

                try {
                    String packageName = mElementUtils.getPackageOf(encloseingElement).getQualifiedName().toString();
                    JavaFile.builder(packageName, classBuilder.build())
                            .build().writeTo(mFiler);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("翻车了");
                }
            }

        }
        return false;
    }


}
