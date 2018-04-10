package com.demo.factoryframeworkforsavedata;

/**
 * Created by 花歹 on 2018/4/9.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class IOHandlerFactory implements IOFactory{

    //有必要可以写成单例设计模式

    private static volatile IOHandlerFactory mInstance;

    private IOHandler mMemoryIOHandler, mPreferencesIOHandler;

    private IOHandlerFactory() {
    }

    public static IOHandlerFactory getInstance() {

        if (mInstance == null) {
            synchronized (IOHandlerFactory.class) {
                if (mInstance == null) {
                    mInstance = new IOHandlerFactory();
                }
            }
        }

        return mInstance;
    }

//    public enum IOType {
//        MEMORY, PREFERENCES,DISK
//    }

    //每次新增一个新的存储方式，需要添加case ,说白了就是需要改动原来很多的代码
    // 1、例如一个Factory对应一个Handler方式，解决改动原来很多的代码来增加新的存储方式，但是随着Factory增加，导致
    // 2、抽象工厂模式
//    public static IOHandler createIOHandler(IOType ioType) {
//        switch (ioType) {
//            case MEMORY:
//                return new MemoryIOHandler();
//
//            case PREFERENCES:
//                return new PreferencesIOHandler();
//
//            default:
//                return null;
//        }
//    }

    // 抽象工厂模式,通过特定的方法 返回单一的对象
    public IOHandler createIOHandler(Class<? extends IOHandler> ioHandlerClass) {
        try {
            return ioHandlerClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new PreferencesIOHandler();
    }

    /**
     * 获取运行内存
     *
     * @return
     */
    public IOHandler getMemoryIOHandler() {
        if (mMemoryIOHandler == null) {
            mMemoryIOHandler = createIOHandler(MemoryIOHandler.class);
        }

        return mMemoryIOHandler;
    }

    /**
     * 获取sp存储
     *
     * @return
     */
    public IOHandler getPreferencesIOHandler() {
        if (mPreferencesIOHandler == null) {
            mPreferencesIOHandler = createIOHandler(PreferencesIOHandler.class);
        }
        return createIOHandler(PreferencesIOHandler.class);
    }

    /**
     * 获取 默认存储
     * 为什么有个默认的，有时候代码写完了，但是网上有很多高效的
     * 又或者本来是用了第三方的，现在有更好的
     *
     * @return
     */
    public IOHandler getDefaultIOHandler() {
        return getPreferencesIOHandler();
    }
}
