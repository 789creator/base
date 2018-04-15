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
@TableName("b2c_spec_item")
public class SpecItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 规格项id
	 */
	@TableId
	private Integer id;
	/**
	 * 规格id
	 */
	private Integer specId;
	/**
	 * 规格项
	 */
	private String item;
	/**
	 * 商家id
	 */
	private Integer storeId;

	/**
	 * 设置：规格项id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：规格项id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：规格id
	 */
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	/**
	 * 获取：规格id
	 */
	public Integer getSpecId() {
		return specId;
	}
	/**
	 * 设置：规格项
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * 获取：规格项
	 */
	public String getItem() {
		return item;
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
