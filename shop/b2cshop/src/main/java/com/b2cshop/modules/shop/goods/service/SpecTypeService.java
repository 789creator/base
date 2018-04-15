package com.b2cshop.modules.shop.goods.service;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.modules.shop.goods.entity.SpecTypeEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 商品类型与规格对应表
 *
 * @author zhj
 * @email
 * @date 2018-04-01 16:17:09
 */
public interface SpecTypeService extends IService<SpecTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

