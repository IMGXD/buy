package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.AdminCustom;

public interface AdminMapperCustom {

    // 通过用户名查找管理员
    AdminCustom findAdminByUsername(String username) throws Exception;

}