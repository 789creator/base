package com.b2cshop.modules.shop.goods.service;

import com.b2cshop.modules.shop.goods.entity.GoodsEntity;
import com.baomidou.mybatisplus.service.IService;
import com.b2cshop.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品
 *
 * @author zhj
 * @email 
 * @date 2018-03-29 09:48:51
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

