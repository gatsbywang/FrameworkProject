package com.butterknife;

import android.app.Activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 花歹 on 2018/3/14.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class ButterKnife {

    public static Unbinder bind(Activity activity) {


        try {
            Class<? extends Unbinder> bindClassName = (Class<? extends Unbinder>)
                    Class.forName(activity.getClass().getName() + "_ViewBinding");
            Constructor<? extends Unbinder> constructor = bindClassName.getDeclaredConstructor(activity.getClass());
            Unbinder unbinder = constructor.newInstance(activity);
            return unbinder;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return Unbinder.EMPTY;
    }
}
