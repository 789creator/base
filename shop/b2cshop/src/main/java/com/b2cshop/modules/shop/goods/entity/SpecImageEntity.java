package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author zhj
 * @email 
 * @date 2018-04-01 16:17:09
 */
@TableName("b2c_spec_image")
public class SpecImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品规格图片表id
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 规格项id
	 */
	private Integer specImageId;
	/**
	 * 商品规格图片路径
	 */
	private String src;
	/**
	 * 商家id
	 */
	private Integer storeId;

	/**
	 * 设置：商品规格图片表id
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品规格图片表id
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：规格项id
	 */
	public void setSpecImageId(Integer specImageId) {
		this.specImageId = specImageId;
	}
	/**
	 * 获取：规格项id
	 */
	public Integer getSpecImageId() {
		return specImageId;
	}
	/**
	 * 设置：商品规格图片路径
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	/**
	 * 获取：商品规格图片路径
	 */
	public String getSrc() {
		return src;
	}
	/**
	 * 设置：商家id
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	/**
	 * 获取：商家id
	 */
	public Integer getStoreId() {
		return storeId;
	}
}
