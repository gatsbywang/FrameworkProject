package com.butterknife;

/**
 * Created by 花歹 on 2018/3/15.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */

public interface Unbinder {
    void unbind();

    Unbinder EMPTY = new Unbinder(){

        @Override
        public void unbind() {

        }
    };
}
