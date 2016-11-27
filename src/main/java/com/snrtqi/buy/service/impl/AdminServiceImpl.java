package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.exception.AdminLoginException;
import com.snrtqi.buy.mapper.AdminMapperCustom;
import com.snrtqi.buy.pojo.AdminCustom;
import com.snrtqi.buy.pojo.AdminQueryVo;
import com.snrtqi.buy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gumo on 2016/11/21.
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapperCustom adminMapperCustom;

    /**
     * 登录功能
     *
     * @param username
     * @param adminQueryVo
     * @return
     * @throws Exception
     */
    public AdminCustom login(String username, AdminQueryVo adminQueryVo) throws Exception {
        //  得到User
        AdminCustom adminCustom = adminMapperCustom.findAdminByUsername(username);

        //  判断User是否为null
        if (adminCustom == null) {
            throw new AdminLoginException("用户名不存在！");
        }

        //  判断密码是否正确
        if (!adminCustom.getPassword().equals(adminQueryVo.getAdminCustom().getPassword())) {
            throw new AdminLoginException("密码错误！");
        }

        //  返回User
        return adminCustom;
    }
}
