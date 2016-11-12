package com.snrtqi.buy.pojo;

/**
 * 用户的包装对象
 * Created by Gumo on 2016/11/12.
 */
public class UserQueryVo {

    // 用户类
    private User user;

    // 用户的扩展类
    private UserCustom userCustom;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
