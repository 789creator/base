package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品与商品属性关系表
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_attr")
public class GoodsAttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品属性id自增
	 */
	@TableId
	private Integer goodsAttrId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 属性id
	 */
	private Integer attrId;
	/**
	 * 属性值
	 */
	private String attrValue;
	/**
	 * 属性价格
	 */
	private String attrPrice;

	/**
	 * 设置：商品属性id自增
	 */
	public void setGoodsAttrId(Integer goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}
	/**
	 * 获取：商品属性id自增
	 */
	public Integer getGoodsAttrId() {
		return goodsAttrId;
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
	 * 设置：属性id
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：属性id
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * 设置：属性值
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	/**
	 * 获取：属性值
	 */
	public String getAttrValue() {
		return attrValue;
	}
	/**
	 * 设置：属性价格
	 */
	public void setAttrPrice(String attrPrice) {
		this.attrPrice = attrPrice;
	}
	/**
	 * 获取：属性价格
	 */
	public String getAttrPrice() {
		return attrPrice;
	}
}
