package com.demo.framework.rxjava;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by 花歹 on 2019/7/9.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class RxLogin {

    private final Activity activity;

//     static UMAuthListener STATIC_LISTENER;

    private RxLoginResult mRxLoginResult;

    private PublishSubject<RxLoginResult> mEmitter ;

    private RxLogin(Activity activity){
        this.activity = activity;
//        STATIC_LISTENER = this;
         mRxLoginResult = new RxLoginResult();
         mEmitter = PublishSubject.create();
    }

    public  static  RxLogin create(Activity activity){
        return new RxLogin(activity);
    }

    public Observable<RxLoginResult> doOauthVerify(RxLoginPlatform platform){

        //开启一个透明的Activity
        Intent intent = new Intent(activity,RxLoginActivity.class);
        intent.putExtra(RxLoginActivity.PLATFORM_KEY,platform);
        activity.startActivity(intent);
        activity.overridePendingTransition(0,0);

        List<Observable<RxLoginResult>> list = new ArrayList<>(1);
        list.add(mEmitter);
        return Observable.concat(Observable.fromIterable(list));
    }


}
