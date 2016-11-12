package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.mapper.UserMapper;
import com.snrtqi.buy.pojo.User;
import com.snrtqi.buy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Gumo on 2016/9/19.
 */
public class UserServiceImpl implements UserService {

    //User接口
    @Autowired
    private UserMapper userMapper;

    public List<User> findUser() throws Exception {
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        List<User> users = userMapper.selectByExample(null);

        return users;
    }
}
