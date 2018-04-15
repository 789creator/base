package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.modules.shop.goods.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsTypeDao;
import com.b2cshop.modules.shop.goods.entity.GoodsTypeEntity;
import com.b2cshop.modules.shop.goods.service.GoodsTypeService;


@Service("goodsTypeService")
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeDao, GoodsTypeEntity> implements GoodsTypeService {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsTypeEntity> page = this.selectPage(
                new Query<GoodsTypeEntity>(params).getPage(),
                new EntityWrapper<GoodsTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils list(Map<String, Object> params) {
        PageUtils page = this.queryPage(params);
        Map<Integer, String> map = goodsCategoryService.getCategoryNameMap();
        for (GoodsTypeEntity goodsType : (List<GoodsTypeEntity>) page.getList()) {
            goodsType.setCatId1Name(map.get(goodsType.getCatId1()));
            goodsType.setCatId2Name(map.get(goodsType.getCatId2()));
            goodsType.setCatId3Name(map.get(goodsType.getCatId3()));
        }
        return page;
    }

}
