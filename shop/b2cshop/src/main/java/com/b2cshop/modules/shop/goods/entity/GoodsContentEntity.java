package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 * 
 * @author zhj
 * @email 
 * @date 2018-03-29 09:48:51
 */
@TableName("b2c_goods_content")
public class GoodsContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品详细id
	 */
	@TableId
	private Integer goodsContentId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 商品详细描述
	 */
	private String goodsContent;

	/**
	 * 设置：商品详细id
	 */
	public void setGoodsContentId(Integer goodsContentId) {
		this.goodsContentId = goodsContentId;
	}
	/**
	 * 获取：商品详细id
	 */
	public Integer getGoodsContentId() {
		return goodsContentId;
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
	 * 设置：商品详细描述
	 */
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	/**
	 * 获取：商品详细描述
	 */
	public String getGoodsContent() {
		return goodsContent;
	}
}
