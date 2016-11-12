package com.snrtqi.buy.service;

import com.snrtqi.buy.pojo.User;

import java.util.List;

/**
 * Created by Gumo on 2016/9/19.
 */
public interface UserService {
    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    List<User> findUser()throws Exception;
}
