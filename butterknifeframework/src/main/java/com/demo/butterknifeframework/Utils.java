package com.demo.butterknifeframework;

import android.app.Activity;
import android.view.View;

/**
 * Created by 花歹 on 2018/3/15.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Utils {
    public static <T extends View> T findViewById(Activity activity,int viewId) {
        return (T)activity.findViewById(viewId);
    }
}
