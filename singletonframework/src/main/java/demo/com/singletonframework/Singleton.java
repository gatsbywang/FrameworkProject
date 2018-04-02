package demo.com.singletonframework;

/**
 * Created by 花歹 on 2018/3/28.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class Singleton {

    //饿汉式，随着类的加载就已经new了对象
    private static Singleton mInstance = new Singleton();

    private Singleton() {

    }


}
