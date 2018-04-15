package com.b2cshop.modules.shop.goods.dao;

import com.b2cshop.modules.shop.goods.entity.GoodsCouponEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品与优惠券关系表
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@Mapper
public interface GoodsCouponDao extends BaseMapper<GoodsCouponEntity> {
	
}
