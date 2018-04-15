package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品咨询
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_consult")
public class GoodsConsultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品咨询id
	 */
	@TableId
	private Integer id;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 网名
	 */
	private String username;
	/**
	 * 咨询时间
	 */
	private Integer addTime;
	/**
	 * 1 商品咨询 2 支付咨询 3 配送 4 售后
	 */
	private Integer consultType;
	/**
	 * 咨询内容
	 */
	private String content;
	/**
	 * 父id 用于管理员回复
	 */
	private Integer parentId;
	/**
	 * 店铺id
	 */
	private Integer storeId;
	/**
	 * 是否显示
	 */
	private Integer isShow;

	/**
	 * 设置：商品咨询id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：商品咨询id
	 */
	public Integer getId() {
		return id;
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
	 * 设置：网名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：网名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：咨询时间
	 */
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：咨询时间
	 */
	public Integer getAddTime() {
		return addTime;
	}
	/**
	 * 设置：1 商品咨询 2 支付咨询 3 配送 4 售后
	 */
	public void setConsultType(Integer consultType) {
		this.consultType = consultType;
	}
	/**
	 * 获取：1 商品咨询 2 支付咨询 3 配送 4 售后
	 */
	public Integer getConsultType() {
		return consultType;
	}
	/**
	 * 设置：咨询内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：咨询内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：父id 用于管理员回复
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父id 用于管理员回复
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：店铺id
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getStoreId() {
		return storeId;
	}
	/**
	 * 设置：是否显示
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否显示
	 */
	public Integer getIsShow() {
		return isShow;
	}
}
