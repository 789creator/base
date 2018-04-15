package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类型
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:18
 */
@TableName("b2c_goods_type")
public class GoodsTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id自增
	 */
	@TableId
	private Integer id;
	/**
	 * 类型名称
	 */
	private String name;
	/**
	 * 一级分类id
	 */
	private Integer catId1;
	/**
	 * 二级分类id
	 */
	private Integer catId2;
	/**
	 * 三级分类id
	 */
	private Integer catId3;

	/**
	 * 一级分类名称
	 */
	@TableField(exist = false)
	private String catId1Name;
	/**
	 * 二级分类名称
	 */
	@TableField(exist = false)
	private String catId2Name;
	/**
	 * 三级分类名称
	 */
	@TableField(exist = false)
	private String catId3Name;

	public String getCatId1Name() {
		return catId1Name;
	}

	public void setCatId1Name(String catId1Name) {
		this.catId1Name = catId1Name;
	}

	public String getCatId2Name() {
		return catId2Name;
	}

	public void setCatId2Name(String catId2Name) {
		this.catId2Name = catId2Name;
	}

	public String getCatId3Name() {
		return catId3Name;
	}

	public void setCatId3Name(String catId3Name) {
		this.catId3Name = catId3Name;
	}

	/**
	 * 设置：id自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id自增
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：类型名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：类型名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：一级分类id
	 */
	public void setCatId1(Integer catId1) {
		this.catId1 = catId1;
	}
	/**
	 * 获取：一级分类id
	 */
	public Integer getCatId1() {
		return catId1;
	}
	/**
	 * 设置：二级分类id
	 */
	public void setCatId2(Integer catId2) {
		this.catId2 = catId2;
	}
	/**
	 * 获取：二级分类id
	 */
	public Integer getCatId2() {
		return catId2;
	}
	/**
	 * 设置：三级分类id
	 */
	public void setCatId3(Integer catId3) {
		this.catId3 = catId3;
	}
	/**
	 * 获取：三级分类id
	 */
	public Integer getCatId3() {
		return catId3;
	}
}
