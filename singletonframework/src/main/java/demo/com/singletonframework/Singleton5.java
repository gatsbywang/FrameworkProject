package demo.com.singletonframework;

/**
 * Created by 花歹 on 2018/4/2.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Singleton5 {

    private static Singleton5 mInstance;

    static {
        mInstance = new Singleton5();
    }

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return mInstance;
    }
}
