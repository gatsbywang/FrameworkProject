package demo.com.singletonframework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 花歹 on 2018/4/2.
 * Email:   gatsbywang@126.com
 * Description: 容器方式，源码中使用比较多，比如ServiceManager等
 * Thought:
 */

public class Singleton4 {
    private static Map<String, Object> mSingleMap = new HashMap<>();

    static {
        mSingleMap.put("activity_map", new Singleton4());
    }

    public Singleton4() {
    }

    public static Object getService(String serviceName) {
        return mSingleMap.get(serviceName);
    }
}
