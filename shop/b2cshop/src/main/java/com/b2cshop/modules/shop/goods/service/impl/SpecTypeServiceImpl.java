package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;
import com.b2cshop.modules.shop.goods.dao.SpecTypeDao;
import com.b2cshop.modules.shop.goods.entity.SpecTypeEntity;
import com.b2cshop.modules.shop.goods.service.SpecTypeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("specTypeService")
public class SpecTypeServiceImpl extends ServiceImpl<SpecTypeDao, SpecTypeEntity> implements SpecTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpecTypeEntity> page = this.selectPage(
                new Query<SpecTypeEntity>(params).getPage(),
                new EntityWrapper<SpecTypeEntity>()
        );

        return new PageUtils(page);
    }

}
