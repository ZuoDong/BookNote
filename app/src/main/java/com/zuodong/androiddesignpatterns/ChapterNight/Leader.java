package com.zuodong.androiddesignpatterns.ChapterNight;

/**
 * Created by dongdong on 2017/3/1.
 *
 * 责任链模式：请求者与处理者之间解耦，例如View的传递机制
 */

public abstract class Leader {
    protected Leader nextLeader;

    public final void handleRequest(int money){
        if(money <= limit()){
            handle(money);
        }else{
            if(null != nextLeader){
                nextLeader.handleRequest(money);
            }
        }
    }

    /**
     * 处理报账行为
     * @param money
     */
    public abstract void handle(int money);

    /**
     * 自身批复的额度权限
     * @return 金额
     */
    public abstract int limit();
}
