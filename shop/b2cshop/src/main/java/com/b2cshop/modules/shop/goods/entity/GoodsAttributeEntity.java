package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品属性
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_attribute")
public class GoodsAttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性id
	 */
	@TableId
	private Integer attrId;
	/**
	 * 属性名称
	 */
	private String attrName;
	/**
	 * 属性分类id
	 */
	private Integer typeId;
	/**
	 * 0不需要检索 1关键字检索
	 */
	private Integer attrIndex;
	/**
	 * 下拉框展示给商家选择
	 */
	private Integer attrType;
	/**
	 * 2多行文本框,平台属性录入方式
	 */
	private Integer attrInputType;
	/**
	 * 可选值列表
	 */
	private String attrValues;
	/**
	 * 属性排序
	 */
	private Integer order;

	/**
	 * 属性分类名称
	 */
	@TableField(exist = false)
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	 * 设置：属性名称
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	/**
	 * 获取：属性名称
	 */
	public String getAttrName() {
		return attrName;
	}
	/**
	 * 设置：属性分类id
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：属性分类id
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * 设置：0不需要检索 1关键字检索
	 */
	public void setAttrIndex(Integer attrIndex) {
		this.attrIndex = attrIndex;
	}
	/**
	 * 获取：0不需要检索 1关键字检索
	 */
	public Integer getAttrIndex() {
		return attrIndex;
	}
	/**
	 * 设置：下拉框展示给商家选择
	 */
	public void setAttrType(Integer attrType) {
		this.attrType = attrType;
	}
	/**
	 * 获取：下拉框展示给商家选择
	 */
	public Integer getAttrType() {
		return attrType;
	}
	/**
	 * 设置：2多行文本框,平台属性录入方式
	 */
	public void setAttrInputType(Integer attrInputType) {
		this.attrInputType = attrInputType;
	}
	/**
	 * 获取：2多行文本框,平台属性录入方式
	 */
	public Integer getAttrInputType() {
		return attrInputType;
	}
	/**
	 * 设置：可选值列表
	 */
	public void setAttrValues(String attrValues) {
		this.attrValues = attrValues;
	}
	/**
	 * 获取：可选值列表
	 */
	public String getAttrValues() {
		return attrValues;
	}
	/**
	 * 设置：属性排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：属性排序
	 */
	public Integer getOrder() {
		return order;
	}
}
