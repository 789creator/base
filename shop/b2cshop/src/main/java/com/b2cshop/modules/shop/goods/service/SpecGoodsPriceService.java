package com.b2cshop.modules.shop.goods.service;

import com.b2cshop.modules.shop.goods.entity.SpecGoodsPriceEntity;
import com.baomidou.mybatisplus.service.IService;
import com.b2cshop.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zhj
 * @email 
 * @date 2018-04-01 16:17:09
 */
public interface SpecGoodsPriceService extends IService<SpecGoodsPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

