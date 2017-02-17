package com.zuodong.androiddesignpatterns.ChapterFour;

/**
 * Created by dongdong on 2017/2/17.
 *
 * 原型模式的应用
 *
 * 登录信息在其他模块不可被修改
 */

public class LoginSession {
    static LoginSession loginSession = null;
    User user = new User();
    private LoginSession(){}

    public static LoginSession getLoginSession(){
        if(loginSession == null){
            loginSession = new LoginSession();
        }
        return loginSession;
    }

    //设置已登录用户信息，不对外开放（包限制级）
    void setLoginUser(User user){
        this.user = user;
    }

    //只提供克隆的对象，避免原有数据被修改
    public User getLoginUser(){
        return user.clone();
    }


}
