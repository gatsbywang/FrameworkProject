package com.demo.factoryframeworkforsavedata;

/**
 * Created by 花歹 on 2018/4/9.
 * Email:   gatsbywang@126.com
 * Description: 生成类的工厂接口
 * Thought:
 */

public interface IOFactory {
//    IOHandler createIOHandler();

    IOHandler createIOHandler(Class<? extends IOHandler> ioHandlerClass);
}
