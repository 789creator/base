package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsImagesDao;
import com.b2cshop.modules.shop.goods.entity.GoodsImagesEntity;
import com.b2cshop.modules.shop.goods.service.GoodsImagesService;


@Service("goodsImagesService")
public class GoodsImagesServiceImpl extends ServiceImpl<GoodsImagesDao, GoodsImagesEntity> implements GoodsImagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsImagesEntity> page = this.selectPage(
                new Query<GoodsImagesEntity>(params).getPage(),
                new EntityWrapper<GoodsImagesEntity>()
        );

        return new PageUtils(page);
    }

}
