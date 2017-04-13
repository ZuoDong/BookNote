package com.zuodong.androiddesignpatterns.ChapterTwentyTwo;

/**
 * Created by dongdong on 2017/4/13.
 */

public class PublicTest {

    public void testPublic(){
        Ticket ticket01 = TicketFactory.getTicket("北京", "青岛");
        ticket01.showTicketInfo("上铺");
        Ticket ticket02 = TicketFactory.getTicket("北京", "青岛");
        ticket02.showTicketInfo("下铺");
        Ticket ticket03 = TicketFactory.getTicket("北京", "青岛");
        ticket03.showTicketInfo("坐票");
    }
}
