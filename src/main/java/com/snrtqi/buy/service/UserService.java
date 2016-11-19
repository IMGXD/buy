package com.snrtqi.buy.service;

import com.snrtqi.buy.pojo.UserCustom;
import com.snrtqi.buy.pojo.UserQueryVo;

/**
 * Created by Gumo on 2016/9/19.
 */
public interface UserService {

    /**
     * 注册功能
     * @param userQueryVo
     * @throws Exception
     */
    void regist(String username, String email, UserQueryVo userQueryVo) throws Exception;

    /**
     * 登录功能
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    UserCustom login(String username, UserQueryVo userQueryVo) throws Exception;
}
