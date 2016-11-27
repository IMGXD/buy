package com.snrtqi.buy.service;

import com.snrtqi.buy.pojo.AdminCustom;
import com.snrtqi.buy.pojo.AdminQueryVo;

/**
 * Created by Gumo on 2016/9/19.
 */
public interface AdminService {

    /**
     * 登录功能
     * @param username
     * @param adminQueryVo
     * @return
     * @throws Exception
     */
    AdminCustom login(String username, AdminQueryVo adminQueryVo) throws Exception;
}
