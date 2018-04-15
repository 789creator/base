package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsAttrDao;
import com.b2cshop.modules.shop.goods.entity.GoodsAttrEntity;
import com.b2cshop.modules.shop.goods.service.GoodsAttrService;


@Service("goodsAttrService")
public class GoodsAttrServiceImpl extends ServiceImpl<GoodsAttrDao, GoodsAttrEntity> implements GoodsAttrService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsAttrEntity> page = this.selectPage(
                new Query<GoodsAttrEntity>(params).getPage(),
                new EntityWrapper<GoodsAttrEntity>()
        );

        return new PageUtils(page);
    }

}
