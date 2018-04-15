package com.b2cshop.modules.shop.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.modules.shop.goods.entity.GoodsVisitEntity;

import java.util.Map;

/**
 * 商品浏览历史表
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
public interface GoodsVisitService extends IService<GoodsVisitEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

