package com.demo.factoryframeworkforsavedata;

/**
 * Created by 花歹 on 2018/4/9.
 * Email:   gatsbywang@126.com
 * Description: 运行内存存储 Factory
 * Thought:
 */

@Deprecated
public class MemoryIOFactory implements IOFactory {
    @Override
    public IOHandler createIOHandler() {
        return new MemoryIOHandler();
    }
}
