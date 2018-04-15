package com.b2cshop.modules.shop.goods.service.impl;

import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;
import com.b2cshop.modules.shop.goods.dao.SpecGoodsPriceDao;
import com.b2cshop.modules.shop.goods.entity.SpecGoodsPriceEntity;
import com.b2cshop.modules.shop.goods.service.SpecGoodsPriceService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("specGoodsPriceService")
public class SpecGoodsPriceServiceImpl extends ServiceImpl<SpecGoodsPriceDao, SpecGoodsPriceEntity> implements SpecGoodsPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpecGoodsPriceEntity> page = this.selectPage(
                new Query<SpecGoodsPriceEntity>(params).getPage(),
                new EntityWrapper<SpecGoodsPriceEntity>()
        );

        return new PageUtils(page);
    }

}
