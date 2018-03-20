package com.demo.payCompiler;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;
import javax.lang.model.util.Types;
import javax.swing.filechooser.FileFilter;

/**
 * Created by 花歹 on 2018/3/20.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class WXPayEntryVisitor extends SimpleAnnotationValueVisitor7<Void,Void>{

    private String mPackageName;
    private TypeMirror mTypeMirror;

    private Filer mfiler;


    @Override
    public Void visitString(String s, Void aVoid) {
        mPackageName = s;
        return super.visitString(s, aVoid);
    }

    @Override
    public Void visitType(TypeMirror typeMirror, Void aVoid) {
        mTypeMirror = typeMirror;
        generateWXPayCode();
        return aVoid;
    }

    public void setFiler(Filer filer) {
        this.mfiler = filer;
    }

    private void generateWXPayCode() {
        //生成一个Class xxx.wxapi.WXPayEntryActivity extends WXPayActivity

        TypeSpec.Builder classSpecBuilder = TypeSpec.classBuilder("WXPayEntryActivity")
                .addModifiers(Modifier.PUBLIC,Modifier.FINAL)
                .superclass(TypeName.get(mTypeMirror));

        try {
            JavaFile.builder(mPackageName+".wxapi",classSpecBuilder.build())
            .addFileComment("微信支付自动生成").build().writeTo(mfiler);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("翻车了");
        }


    }
}
