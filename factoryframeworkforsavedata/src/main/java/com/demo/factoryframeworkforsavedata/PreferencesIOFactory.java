package com.demo.factoryframeworkforsavedata;

/**
 * Created by 花歹 on 2018/4/9.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

@Deprecated
public class PreferencesIOFactory implements IOFactory {
    @Override
    public IOHandler createIOHandler() {
        return new PreferencesIOHandler();
    }
}
