package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品收藏
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_collect")
public class GoodsCollectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer collectId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 
	 */
	private Integer catId3;
	/**
	 * 添加时间
	 */
	private Integer addTime;

	/**
	 * 设置：
	 */
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	/**
	 * 获取：
	 */
	public Integer getCollectId() {
		return collectId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：商品id
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品id
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：
	 */
	public void setCatId3(Integer catId3) {
		this.catId3 = catId3;
	}
	/**
	 * 获取：
	 */
	public Integer getCatId3() {
		return catId3;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Integer getAddTime() {
		return addTime;
	}
}
