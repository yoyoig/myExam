package com.hand.DTO;

/**
 * Created by 铭刻 on 2017/8/17.
 */
public class LoginSuccess {

    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    @Override
    public String toString() {
        return "LoginSuccess{" +
                "isLogin=" + isLogin +
                '}';
    }
}
