package com.demo.framework.flyweight;

/**
 * Created by 花歹 on 2019/5/15.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class Ticket {
    private  String to;
    private  String from;

    public Ticket(String from, String to) {
        this.to = to;
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to){
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
