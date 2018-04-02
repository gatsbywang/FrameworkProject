package demo.com.singletonframework;

/**
 * Created by 花歹 on 2018/4/2.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Singleton3 {

    //使用静态内部类方式
    public static Singleton3 getInstance3() {
        return Singleton3.SingletonHolder.mInsance;
    }

    //静态内部类下的单例
    public static class SingletonHolder {

        private static volatile Singleton3 mInsance;
    }
}
