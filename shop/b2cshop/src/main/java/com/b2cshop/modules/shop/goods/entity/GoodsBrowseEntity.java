package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品浏览历史表
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_browse")
public class GoodsBrowseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 会员ID
	 */
	private Integer memberId;
	/**
	 * 浏览时间
	 */
	private Integer browsetime;
	/**
	 * 商品分类
	 */
	private Integer gcId;
	/**
	 * 商品一级分类
	 */
	private Integer gcId1;
	/**
	 * 商品二级分类
	 */
	private Integer gcId2;
	/**
	 * 商品三级分类
	 */
	private Integer gcId3;

	/**
	 * 设置：商品ID
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品ID
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：会员ID
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：浏览时间
	 */
	public void setBrowsetime(Integer browsetime) {
		this.browsetime = browsetime;
	}
	/**
	 * 获取：浏览时间
	 */
	public Integer getBrowsetime() {
		return browsetime;
	}
	/**
	 * 设置：商品分类
	 */
	public void setGcId(Integer gcId) {
		this.gcId = gcId;
	}
	/**
	 * 获取：商品分类
	 */
	public Integer getGcId() {
		return gcId;
	}
	/**
	 * 设置：商品一级分类
	 */
	public void setGcId1(Integer gcId1) {
		this.gcId1 = gcId1;
	}
	/**
	 * 获取：商品一级分类
	 */
	public Integer getGcId1() {
		return gcId1;
	}
	/**
	 * 设置：商品二级分类
	 */
	public void setGcId2(Integer gcId2) {
		this.gcId2 = gcId2;
	}
	/**
	 * 获取：商品二级分类
	 */
	public Integer getGcId2() {
		return gcId2;
	}
	/**
	 * 设置：商品三级分类
	 */
	public void setGcId3(Integer gcId3) {
		this.gcId3 = gcId3;
	}
	/**
	 * 获取：商品三级分类
	 */
	public Integer getGcId3() {
		return gcId3;
	}
}
