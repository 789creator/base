package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品图片
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_images")
public class GoodsImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图片id 自增
	 */
	@TableId
	private Integer imgId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 商品缩略图排序,最小的拍最前面
	 */
	private Integer imgSort;

	/**
	 * 设置：图片id 自增
	 */
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	/**
	 * 获取：图片id 自增
	 */
	public Integer getImgId() {
		return imgId;
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
	 * 设置：图片地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：商品缩略图排序,最小的拍最前面
	 */
	public void setImgSort(Integer imgSort) {
		this.imgSort = imgSort;
	}
	/**
	 * 获取：商品缩略图排序,最小的拍最前面
	 */
	public Integer getImgSort() {
		return imgSort;
	}
}
