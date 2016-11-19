package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.exception.LoginException;
import com.snrtqi.buy.exception.RegistException;
import com.snrtqi.buy.mapper.UserMapper;
import com.snrtqi.buy.mapper.UserMapperCustom;
import com.snrtqi.buy.pojo.User;
import com.snrtqi.buy.pojo.UserCustom;
import com.snrtqi.buy.pojo.UserQueryVo;
import com.snrtqi.buy.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gumo on 2016/9/19.
 */
public class UserServiceImpl implements UserService {

    //  User接口
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    /**
     * 注册功能
     *
     * @param username
     * @param userQueryVo
     * @throws Exception
     */
    public void regist(String username, String email, UserQueryVo userQueryVo) throws Exception {
        //  校验用户名
        UserCustom findUser = userMapperCustom.findUserByUsername(username);
        if (findUser != null) {
            throw new RegistException("用户名已被注册！");
        }

        //  校验email
        findUser = userMapperCustom.findUserByEmail(email);
        if (findUser != null) {
            throw new RegistException("Email已被注册！");
        }

        User user = new User();
        BeanUtils.copyProperties(userQueryVo.getUserCustom(), user);
        // 插入用户到数据库中
        userMapper.insert(user);
    }

    /**
     * 登录功能
     *
     * @param username
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    public UserCustom login(String username, UserQueryVo userQueryVo) throws Exception {
        //  得到User
        UserCustom userCustom = userMapperCustom.findUserByUsername(username);

        //  判断User是否为null
        if (userCustom == null) {
            throw new LoginException("用户名不存在！");
        }

        //  判断密码是否正确
        if (!userCustom.getPassword().equals(userQueryVo.getUserCustom().getPassword())) {
            throw new LoginException("密码错误！");
        }

        //  返回User
        return userCustom;
    }


}
