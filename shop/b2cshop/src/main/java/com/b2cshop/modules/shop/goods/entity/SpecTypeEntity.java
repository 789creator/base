package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类型与规格对应表
 * 
 * @author zhj
 * @email 
 * @date 2018-04-01 16:17:09
 */
@TableName("b2c_spec_type")
public class SpecTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类型id
	 */
	@TableId
	private Integer typeId;
	/**
	 * 规格id
	 */
	private Integer specId;

	/**
	 * 设置：类型id
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：类型id
	 */
	public Integer getTypeId() {
		return typeId;
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
}
