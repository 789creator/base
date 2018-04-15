package com.b2cshop.modules.shop.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.modules.shop.goods.entity.GoodsTypeEntity;

import java.util.Map;

/**
 * 商品类型
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:18
 */
public interface GoodsTypeService extends IService<GoodsTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils list(Map<String, Object> params);
}

