package com.snrtqi.buy.util;

import java.util.UUID;

/**
 * 工具类
 * Created by Gumo on 2016/11/19.
 */
public class CommonUtils {

    /**
     * 获取uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
