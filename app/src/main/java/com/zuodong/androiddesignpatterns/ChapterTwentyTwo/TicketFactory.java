package com.zuodong.androiddesignpatterns.ChapterTwentyTwo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dongdong on 2017/4/13.
 *
 * 享元模式
 *
 * 此方法是建立缓存池，多地方同时买票，查询数据库耗费时间
 */

public class TicketFactory {

    static Map<String,Ticket> ticketMap = new ConcurrentHashMap<>();

    public static Ticket getTicket(String form,String to){
        String key = form + "-" + to;
        if(ticketMap.containsKey(key)){
            System.out.println("使用缓存 ==> "+key);
            return ticketMap.get(key);
        }else{
            System.out.println("创建对象 ==> "+key);
            Ticket ticket = new TrainTicket(form,to);
            ticketMap.put(key,ticket);
            return ticket;
        }
    }
}
