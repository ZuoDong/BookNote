package com.zuodong.androiddesignpatterns.ChapterNine;

/**
 * Created by dongdong on 2017/3/1.
 */

public class GroupLeader extends Leader {
    @Override
    public void handle(int money) {
        System.out.println("组长批复报销"+money+"元");
    }

    @Override
    public int limit() {
        return 1000;
    }
}
