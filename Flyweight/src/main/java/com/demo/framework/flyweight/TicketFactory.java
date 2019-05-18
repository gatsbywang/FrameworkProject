package com.demo.framework.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 花歹 on 2019/5/15.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class TicketFactory {

    //做一个缓存

    static Map<String,Ticket> sTicketMap = new HashMap<>();





    public static Ticket getTicket(String from,String to){

        String key = from + "-"+to;
        Ticket ticket = sTicketMap.get(key);
        if(ticket !=null){
            return ticket;
        }

        ticket = new Ticket(from,to);
        sTicketMap.put(key,ticket);

        return new Ticket(from,to);
    }
}
