package com.demo.activitymanagerframework;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by 花歹 on 2018/4/2.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class ActivityManager {

    private static volatile ActivityManager mInstance;

    //集合
    private Stack<Activity> mActivities;


    private ActivityManager() {
        mActivities = new Stack<>();
    }

    public static synchronized ActivityManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    public void attach(Activity activity) {
        mActivities.add(activity);
    }

    public void detach(Activity detachActivity) {
        //For 循环中移除 有问题
//        for (Activity activity : mActivities) {
//            if (activity == detachActivity) {
//                mActivities.remove(activity);
//            }
//        }


        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivities.get(i);
            if (detachActivity == activity) {
                mActivities.remove(i);
                i--;
                size--;
            }
        }
    }

    /**
     * 解绑，移除 - 防止内存泄漏
     *
     * @param activityClass
     */
    public void finish(Class<? extends Activity> activityClass) {
//        for (Activity activity : mActivities) {
//            if (activity.getClass().getCanonicalName().endsWith(activityClass.getCanonicalName())) {
//                mActivities.remove(activity);
//                activity.finish();
//            }
//        }

        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivities.get(i);
            if (activity.getClass().getCanonicalName().endsWith(activityClass.getCanonicalName())) {
                mActivities.remove(i);
                i--;
                size--;
            }
        }
    }

    /**
     * 解绑，移除 - 防止内存泄漏
     *
     * @param finishActivity
     */
    public void finish(Activity finishActivity) {
//        for (Activity activity : mActivities) {
//            if (activity == finishActivity) {
//                mActivities.remove(activity);
//                activity.finish();
//            }
//        }

        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivities.get(i);
            if (activity == finishActivity) {
                mActivities.remove(i);
                i--;
                size--;
            }
        }
    }

    public void exitApplication() {

    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    public Activity currentActivity() {
        return mActivities.lastElement();
    }
}
