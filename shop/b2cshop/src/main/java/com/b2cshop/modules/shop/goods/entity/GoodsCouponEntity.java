package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品与优惠券关系表
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_coupon")
public class GoodsCouponEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 优惠券id
	 */
	@TableId
	private Integer couponId;
	/**
	 * 指定的商品id：为零表示不指定商品
	 */
	private Integer goodsId;
	/**
	 * 指定的商品分类：为零表示不指定分类
	 */
	private Integer goodsCategoryId;

	/**
	 * 设置：优惠券id
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：优惠券id
	 */
	public Integer getCouponId() {
		return couponId;
	}
	/**
	 * 设置：指定的商品id：为零表示不指定商品
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：指定的商品id：为零表示不指定商品
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：指定的商品分类：为零表示不指定分类
	 */
	public void setGoodsCategoryId(Integer goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}
	/**
	 * 获取：指定的商品分类：为零表示不指定分类
	 */
	public Integer getGoodsCategoryId() {
		return goodsCategoryId;
	}
}
