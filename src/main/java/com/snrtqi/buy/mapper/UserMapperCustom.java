package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.UserCustom;

public interface UserMapperCustom {

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     * @throws Exception
     */
    UserCustom findUserByUsername(String username) throws Exception;

    /**
     * 通过邮箱查找用户
     *
     * @param email
     * @return
     * @throws Exception
     */
    UserCustom findUserByEmail(String email) throws Exception;
}