package com.demo.framework.observer;

/**
 * Created by 花歹 on 2018/6/4.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public class DatabaseManager {

    private static volatile DatabaseManager mInstance;

    private Observable<Member, Observer<Member>> mObservable;

    public DatabaseManager() {
        mObservable = new Observable<>();
    }

    public static DatabaseManager getInstanc() {
        if (mInstance == null) {
            synchronized (DatabaseManager.class) {
                if (mInstance == null) {
                    mInstance = new DatabaseManager();
                }
            }
        }
        return mInstance;
    }

    public void insert(Member member) {
        //插入数据库

        //通知观察者
        mObservable.addUpdater(member);
    }


    public void register(Observer<Member> observer) {
        mObservable.register(observer);
    }

    public void unRegister(Observer<Member> observer) {
        mObservable.unRegister(observer);
    }

}
