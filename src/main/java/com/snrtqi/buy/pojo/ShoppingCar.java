package com.snrtqi.buy.pojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车类
 * Created by Gumo on 2016/11/20.
 */
public class ShoppingCar {

    //  定义map
    private Map<String, ShoppingCarItemCustom> map = new LinkedHashMap<String, ShoppingCarItemCustom>();

    /**
     * 计算合计
     * @return
     */
    public double getTotal() {
        BigDecimal total = new BigDecimal("0");
        for(ShoppingCarItemCustom shoppingCarItemCustom : map.values()) {
            BigDecimal subtotal = new BigDecimal(shoppingCarItemCustom.getSubtotal());
            total = total.add(subtotal);
        }
        return total.doubleValue();
    }

    /**
     * 添加条目到车中
     *
     * @param shoppingCarItemCustom
     */
    public void add(ShoppingCarItemCustom shoppingCarItemCustom) {
        //  判断原来车中是否存在该条目
        if (map.containsKey(shoppingCarItemCustom.getBookCustom().getBid())) {
            //  返回原条目
            ShoppingCarItemCustom _shoppingCarItemCustom = map.get(shoppingCarItemCustom.getBookCustom().getBid());
            //  设置老条目的数量为，其原数量+新条目的数量
            _shoppingCarItemCustom.setCount(_shoppingCarItemCustom.getCount() + shoppingCarItemCustom.getCount());
            //  设置回map
            map.put(shoppingCarItemCustom.getBookCustom().getBid(), _shoppingCarItemCustom);
        } else {
            map.put(shoppingCarItemCustom.getBookCustom().getBid(), shoppingCarItemCustom);
        }
    }


    /**
     * 清空条目
     */
    public void clear() {
        map.clear();
    }

    /**
     * 删除条目
     *
     * @param bid
     */
    public void delete(String bid) {
        map.remove(bid);
    }

    /**
     * 我的购物车
     *
     * @return
     */
    public Collection<ShoppingCarItemCustom> getShoppingCartItems() {
        return map.values();
    }
}
