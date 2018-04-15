package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsCouponDao;
import com.b2cshop.modules.shop.goods.entity.GoodsCouponEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCouponService;


@Service("goodsCouponService")
public class GoodsCouponServiceImpl extends ServiceImpl<GoodsCouponDao, GoodsCouponEntity> implements GoodsCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsCouponEntity> page = this.selectPage(
                new Query<GoodsCouponEntity>(params).getPage(),
                new EntityWrapper<GoodsCouponEntity>()
        );

        return new PageUtils(page);
    }

}
