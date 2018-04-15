package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsBrowseDao;
import com.b2cshop.modules.shop.goods.entity.GoodsBrowseEntity;
import com.b2cshop.modules.shop.goods.service.GoodsBrowseService;


@Service("goodsBrowseService")
public class GoodsBrowseServiceImpl extends ServiceImpl<GoodsBrowseDao, GoodsBrowseEntity> implements GoodsBrowseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsBrowseEntity> page = this.selectPage(
                new Query<GoodsBrowseEntity>(params).getPage(),
                new EntityWrapper<GoodsBrowseEntity>()
        );

        return new PageUtils(page);
    }

}
