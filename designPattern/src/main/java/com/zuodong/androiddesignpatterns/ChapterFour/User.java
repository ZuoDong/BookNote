package com.zuodong.androiddesignpatterns.ChapterFour;

/**
 * Created by dongdong on 2017/2/17.
 */

public class User implements Cloneable{
    public String name;
    public int age;
    public String phoneNumber;

    @Override
    protected User clone() {
        User user = null;
        try {
            user = (User)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return user;
    }
}
