package demo.com.singletonframework;

/**
 * Created by 花歹 on 2018/3/28.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Singleton2 {

    //懒汉式，使用的时候才去new对象 (同步锁 DCL)
    //有个问题，存在多线程并发的问题
    private static Singleton2 mInstance;


    //加上 volatile 用处是什么？
    //1、防止重排序 2、线程可见性
    private static volatile Singleton2 mInstance2;

    private Singleton2() {

    }


    //虽然解决了线程安全的问题，但是又会出现效率的问题
    public static synchronized Singleton2 getInstance() {
        if (mInstance == null) {

            mInstance = new Singleton2();
        }

        return mInstance;
    }

    //即解决了线程安全的问题，效率也比较高
    //
    public static synchronized Singleton2 getInstance2() {
        if (mInstance == null) {
            synchronized (Singleton2.class) {
                if (mInstance == null) {
                    mInstance = new Singleton2();
                }
            }
        }

        return mInstance;
    }


}
