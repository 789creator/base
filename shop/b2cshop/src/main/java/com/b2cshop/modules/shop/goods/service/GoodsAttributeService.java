package com.b2cshop.modules.shop.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.modules.shop.goods.entity.GoodsAttributeEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
public interface GoodsAttributeService extends IService<GoodsAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 商品属性列表
     * @param params
     * @return
     */
    PageUtils list(Map<String, Object> params);
}

