package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsVisitDao;
import com.b2cshop.modules.shop.goods.entity.GoodsVisitEntity;
import com.b2cshop.modules.shop.goods.service.GoodsVisitService;


@Service("goodsVisitService")
public class GoodsVisitServiceImpl extends ServiceImpl<GoodsVisitDao, GoodsVisitEntity> implements GoodsVisitService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsVisitEntity> page = this.selectPage(
                new Query<GoodsVisitEntity>(params).getPage(),
                new EntityWrapper<GoodsVisitEntity>()
        );

        return new PageUtils(page);
    }

}
