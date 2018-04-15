package com.b2cshop.modules.shop.goods.service;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.modules.shop.goods.entity.SpecEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @author zhj
 * @email
 * @date 2018-04-01 16:17:09
 */
public interface SpecService extends IService<SpecEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 商品规格列表
     * @param params
     * @return
     */
    PageUtils list(Map<String, Object> params);

    /**
     * 商品规格列表，通过catids查询
     * @param params
     * @return
     */
    List<SpecEntity> listSpecByIds(Map<String, Object> params);
}

