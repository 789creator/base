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
@TableName("b2c_goods_visit")
public class GoodsVisitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 会员ID
	 */
	private Integer userId;
	/**
	 * 浏览时间
	 */
	private Integer visittime;
	/**
	 * 商品一级分类
	 */
	private Integer catId1;
	/**
	 * 商品二级分类
	 */
	private Integer catId2;
	/**
	 * 商品三级分类
	 */
	private Integer catId3;
	/**
	 * 自增ID
	 */
	private Integer visitId;

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
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：浏览时间
	 */
	public void setVisittime(Integer visittime) {
		this.visittime = visittime;
	}
	/**
	 * 获取：浏览时间
	 */
	public Integer getVisittime() {
		return visittime;
	}
	/**
	 * 设置：商品一级分类
	 */
	public void setCatId1(Integer catId1) {
		this.catId1 = catId1;
	}
	/**
	 * 获取：商品一级分类
	 */
	public Integer getCatId1() {
		return catId1;
	}
	/**
	 * 设置：商品二级分类
	 */
	public void setCatId2(Integer catId2) {
		this.catId2 = catId2;
	}
	/**
	 * 获取：商品二级分类
	 */
	public Integer getCatId2() {
		return catId2;
	}
	/**
	 * 设置：商品三级分类
	 */
	public void setCatId3(Integer catId3) {
		this.catId3 = catId3;
	}
	/**
	 * 获取：商品三级分类
	 */
	public Integer getCatId3() {
		return catId3;
	}
	/**
	 * 设置：自增ID
	 */
	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}
	/**
	 * 获取：自增ID
	 */
	public Integer getVisitId() {
		return visitId;
	}
}
