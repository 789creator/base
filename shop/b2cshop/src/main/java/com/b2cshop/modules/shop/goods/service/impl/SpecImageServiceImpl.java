package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;
import com.b2cshop.modules.shop.goods.dao.SpecImageDao;
import com.b2cshop.modules.shop.goods.entity.SpecImageEntity;
import com.b2cshop.modules.shop.goods.service.SpecImageService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("specImageService")
public class SpecImageServiceImpl extends ServiceImpl<SpecImageDao, SpecImageEntity> implements SpecImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpecImageEntity> page = this.selectPage(
                new Query<SpecImageEntity>(params).getPage(),
                new EntityWrapper<SpecImageEntity>()
        );

        return new PageUtils(page);
    }

}
