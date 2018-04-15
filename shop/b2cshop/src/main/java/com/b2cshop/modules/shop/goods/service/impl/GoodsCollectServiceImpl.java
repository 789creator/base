package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsCollectDao;
import com.b2cshop.modules.shop.goods.entity.GoodsCollectEntity;
import com.b2cshop.modules.shop.goods.service.GoodsCollectService;


@Service("goodsCollectService")
public class GoodsCollectServiceImpl extends ServiceImpl<GoodsCollectDao, GoodsCollectEntity> implements GoodsCollectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsCollectEntity> page = this.selectPage(
                new Query<GoodsCollectEntity>(params).getPage(),
                new EntityWrapper<GoodsCollectEntity>()
        );

        return new PageUtils(page);
    }

}
