package com.b2cshop.modules.shop.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.b2cshop.common.utils.PageUtils;
import com.b2cshop.common.utils.Query;

import com.b2cshop.modules.shop.goods.dao.GoodsConsultDao;
import com.b2cshop.modules.shop.goods.entity.GoodsConsultEntity;
import com.b2cshop.modules.shop.goods.service.GoodsConsultService;


@Service("goodsConsultService")
public class GoodsConsultServiceImpl extends ServiceImpl<GoodsConsultDao, GoodsConsultEntity> implements GoodsConsultService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsConsultEntity> page = this.selectPage(
                new Query<GoodsConsultEntity>(params).getPage(),
                new EntityWrapper<GoodsConsultEntity>()
        );

        return new PageUtils(page);
    }

}
