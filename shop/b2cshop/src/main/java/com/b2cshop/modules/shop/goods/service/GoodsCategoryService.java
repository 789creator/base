package com.b2cshop.modules.shop.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.modules.shop.goods.entity.GoodsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品分类
 *
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
public interface GoodsCategoryService extends IService<GoodsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有商品分类
     * @return
     */
    List<GoodsCategoryEntity> selectAllList();

    /**
     * 获取分类名称map
     * @return
     */
    Map<Integer,String> getCategoryNameMap();
}

