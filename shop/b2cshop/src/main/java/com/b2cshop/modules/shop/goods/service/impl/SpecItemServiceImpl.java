package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;
import com.b2cshop.modules.shop.goods.dao.SpecItemDao;
import com.b2cshop.modules.shop.goods.entity.SpecItemEntity;
import com.b2cshop.modules.shop.goods.service.SpecItemService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service("specItemService")
public class SpecItemServiceImpl extends ServiceImpl<SpecItemDao, SpecItemEntity> implements SpecItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpecItemEntity> page = this.selectPage(
                new Query<SpecItemEntity>(params).getPage(),
                new EntityWrapper<SpecItemEntity>()
        );

        return new PageUtils(page);
    }

}
