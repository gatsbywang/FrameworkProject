package com.demo.aopframework;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by 花歹 on 2018/2/28.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

@Aspect
public class SectionAspect {

    /**
     * 找到处理的切点
     * <p>
     * * *(..) 处理所有的方法
     */
    @Pointcut("execution(@com.demo.aopframework.CheckNet * *(..))")
    public void checkNetBehavior() {

    }

    /**
     * 处理切面
     *
     * @return
     */
    @Around("checkNetBehavior()")
    public Object checkNet(ProceedingJoinPoint joinPoint) throws Throwable {

        //埋点 日志上传 权限检测

        //网络检测
        //1、获取CheckNet注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
        if (checkNet != null) {
            //2、判断有没有网络 怎么获取context
            Object object = joinPoint.getThis();//View  Activity Fragment 当前切点所在的类
            Context context = getContext(object);
            if (context != null) {
                if (!isNetworkAvailable(context)) {
                    return null;
                }
            }
        }

        return joinPoint.proceed();
    }

    private Context getContext(Object object) {
        if (object instanceof Activity) {
            return (Activity) object;
        } else if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            return fragment.getActivity();
        } else if (object instanceof View) {
            View view = (View) object;
            return view.getContext();
        }
        return null;
    }

    public static boolean isNetworkAvailable(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
