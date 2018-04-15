package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.modules.shop.goods.dao.GoodsContentDao;
import com.b2cshop.modules.shop.goods.entity.GoodsContentEntity;
import com.b2cshop.modules.shop.goods.service.GoodsContentService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;



@Service("goodsContentService")
public class GoodsContentServiceImpl extends ServiceImpl<GoodsContentDao, GoodsContentEntity> implements GoodsContentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsContentEntity> page = this.selectPage(
                new Query<GoodsContentEntity>(params).getPage(),
                new EntityWrapper<GoodsContentEntity>()
        );

        return new PageUtils(page);
    }

}
