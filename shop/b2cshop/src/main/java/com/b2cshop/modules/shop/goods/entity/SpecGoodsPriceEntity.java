package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author zhj
 * @email 
 * @date 2018-04-01 16:17:09
 */
@TableName("b2c_spec_goods_price")
public class SpecGoodsPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 规格商品id
	 */
	@TableId
	private Long itemId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 商品规格备注
	 */
	private String goodsMark;
	/**
	 * 规格键名
	 */
	private String key;
	/**
	 * 规格键名中文
	 */
	private String keyName;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 库存数量
	 */
	private Integer storeCount;
	/**
	 * 商品条形码
	 */
	private String barCode;
	/**
	 * SKU
	 */
	private String sku;
	/**
	 * 店铺商家id
	 */
	private Integer storeId;
	/**
	 * 规格商品主图
	 */
	private String specImg;
	/**
	 * 参加活动id
	 */
	private Integer promId;
	/**
	 * 参加活动类型
	 */
	private Integer promType;

	/**
	 * 设置：规格商品id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * 获取：规格商品id
	 */
	public Long getItemId() {
		return itemId;
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
	 * 设置：商品规格备注
	 */
	public void setGoodsMark(String goodsMark) {
		this.goodsMark = goodsMark;
	}
	/**
	 * 获取：商品规格备注
	 */
	public String getGoodsMark() {
		return goodsMark;
	}
	/**
	 * 设置：规格键名
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：规格键名
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：规格键名中文
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	/**
	 * 获取：规格键名中文
	 */
	public String getKeyName() {
		return keyName;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：库存数量
	 */
	public void setStoreCount(Integer storeCount) {
		this.storeCount = storeCount;
	}
	/**
	 * 获取：库存数量
	 */
	public Integer getStoreCount() {
		return storeCount;
	}
	/**
	 * 设置：商品条形码
	 */
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	/**
	 * 获取：商品条形码
	 */
	public String getBarCode() {
		return barCode;
	}
	/**
	 * 设置：SKU
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}
	/**
	 * 获取：SKU
	 */
	public String getSku() {
		return sku;
	}
	/**
	 * 设置：店铺商家id
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	/**
	 * 获取：店铺商家id
	 */
	public Integer getStoreId() {
		return storeId;
	}
	/**
	 * 设置：规格商品主图
	 */
	public void setSpecImg(String specImg) {
		this.specImg = specImg;
	}
	/**
	 * 获取：规格商品主图
	 */
	public String getSpecImg() {
		return specImg;
	}
	/**
	 * 设置：参加活动id
	 */
	public void setPromId(Integer promId) {
		this.promId = promId;
	}
	/**
	 * 获取：参加活动id
	 */
	public Integer getPromId() {
		return promId;
	}
	/**
	 * 设置：参加活动类型
	 */
	public void setPromType(Integer promType) {
		this.promType = promType;
	}
	/**
	 * 获取：参加活动类型
	 */
	public Integer getPromType() {
		return promType;
	}
}
