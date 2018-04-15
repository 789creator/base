package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 * 
 * @author zhj
 * @email 
 * @date 2018-03-29 09:48:51
 */
@TableName("b2c_goods")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 一级分类id
	 */
	private Integer catId1;
	/**
	 * 二级分类
	 */
	private Integer catId2;
	/**
	 * 三级分类
	 */
	private Integer catId3;
	/**
	 * 本店一级分类
	 */
	private Integer storeCatId1;
	/**
	 * 本店二级分类
	 */
	private Integer storeCatId2;
	/**
	 * 商品编号
	 */
	private String goodsSn;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 点击数
	 */
	private Integer clickCount;
	/**
	 * 品牌id
	 */
	private Integer brandId;
	/**
	 * 库存数量
	 */
	private Integer storeCount;
	/**
	 * 商品收藏数
	 */
	private Integer collectSum;
	/**
	 * 商品评论数
	 */
	private Integer commentCount;
	/**
	 * 商品重量克为单位
	 */
	private Integer weight;
	/**
	 * 市场价
	 */
	private BigDecimal marketPrice;
	/**
	 * 本店价
	 */
	private BigDecimal shopPrice;
	/**
	 * 商品成本价
	 */
	private BigDecimal costPrice;
	/**
	 * COMMENT '积分兑换：0不参与积分兑换
	 */
	private Integer exchangeIntegral;
	/**
	 * 商品关键词
	 */
	private String keywords;
	/**
	 * 商品简单描述
	 */
	private String goodsRemark;
	/**
	 * 商品上传原始图
	 */
	private String originalImg;
	/**
	 * 是否为虚拟商品 1是，0否
	 */
	private Integer isVirtual;
	/**
	 * 虚拟商品有效期
	 */
	private Integer virtualIndate;
	/**
	 * 虚拟商品购买上限
	 */
	private Integer virtualLimit;
	/**
	 * 是否允许过期退款， 1是，0否
	 */
	private Integer virtualRefund;
	/**
	 * 0下架1上架2违规下架
	 */
	private Integer isOnSale;
	/**
	 * 是否包邮0否1是
	 */
	private Integer isFreeShipping;
	/**
	 * 商品上架时间
	 */
	private Integer onTime;
	/**
	 * 商品排序
	 */
	private Integer sort;
	/**
	 * 是否推荐
	 */
	private Integer isRecommend;
	/**
	 * 是否新品
	 */
	private Integer isNew;
	/**
	 * 是否热卖
	 */
	private Integer isHot;
	/**
	 * 最后更新时间
	 */
	private Integer lastUpdate;
	/**
	 * 商品所属类型id，取值表goods_type的id
	 */
	private Integer goodsType;
	/**
	 * 购买商品赠送积分
	 */
	private Integer giveIntegral;
	/**
	 * 商品销量
	 */
	private Integer salesSum;
	/**
	 * 0默认1抢购2团购3优惠促销
	 */
	private Integer promType;
	/**
	 * 优惠活动id
	 */
	private Integer promId;
	/**
	 * 佣金用于分销分成
	 */
	private BigDecimal distribut;
	/**
	 * 商家店铺ID
	 */
	private Integer storeId;
	/**
	 * SPU
	 */
	private String spu;
	/**
	 * SKU
	 */
	private String sku;
	/**
	 * 0待审核1审核通过2审核失败
	 */
	private Integer goodsState;
	/**
	 * 违规下架原因
	 */
	private String closeReason;
	/**
	 * 供应商ID
	 */
	private Integer suppliersId;
	/**
	 * 配送物流shipping_area_id,以逗号分隔
	 */
	private String shippingAreaIds;
	/**
	 * 1:第三方自营店,2:总平台自营店
	 */
	private Integer isOwnShop;

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
	 * 设置：二级分类
	 */
	public void setCatId2(Integer catId2) {
		this.catId2 = catId2;
	}
	/**
	 * 获取：二级分类
	 */
	public Integer getCatId2() {
		return catId2;
	}
	/**
	 * 设置：三级分类
	 */
	public void setCatId3(Integer catId3) {
		this.catId3 = catId3;
	}
	/**
	 * 获取：三级分类
	 */
	public Integer getCatId3() {
		return catId3;
	}
	/**
	 * 设置：本店一级分类
	 */
	public void setStoreCatId1(Integer storeCatId1) {
		this.storeCatId1 = storeCatId1;
	}
	/**
	 * 获取：本店一级分类
	 */
	public Integer getStoreCatId1() {
		return storeCatId1;
	}
	/**
	 * 设置：本店二级分类
	 */
	public void setStoreCatId2(Integer storeCatId2) {
		this.storeCatId2 = storeCatId2;
	}
	/**
	 * 获取：本店二级分类
	 */
	public Integer getStoreCatId2() {
		return storeCatId2;
	}
	/**
	 * 设置：商品编号
	 */
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	/**
	 * 获取：商品编号
	 */
	public String getGoodsSn() {
		return goodsSn;
	}
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：点击数
	 */
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
	/**
	 * 获取：点击数
	 */
	public Integer getClickCount() {
		return clickCount;
	}
	/**
	 * 设置：品牌id
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌id
	 */
	public Integer getBrandId() {
		return brandId;
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
	 * 设置：商品收藏数
	 */
	public void setCollectSum(Integer collectSum) {
		this.collectSum = collectSum;
	}
	/**
	 * 获取：商品收藏数
	 */
	public Integer getCollectSum() {
		return collectSum;
	}
	/**
	 * 设置：商品评论数
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 获取：商品评论数
	 */
	public Integer getCommentCount() {
		return commentCount;
	}
	/**
	 * 设置：商品重量克为单位
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * 获取：商品重量克为单位
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * 设置：市场价
	 */
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	/**
	 * 获取：市场价
	 */
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	/**
	 * 设置：本店价
	 */
	public void setShopPrice(BigDecimal shopPrice) {
		this.shopPrice = shopPrice;
	}
	/**
	 * 获取：本店价
	 */
	public BigDecimal getShopPrice() {
		return shopPrice;
	}
	/**
	 * 设置：商品成本价
	 */
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：商品成本价
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	/**
	 * 设置：COMMENT '积分兑换：0不参与积分兑换
	 */
	public void setExchangeIntegral(Integer exchangeIntegral) {
		this.exchangeIntegral = exchangeIntegral;
	}
	/**
	 * 获取：COMMENT '积分兑换：0不参与积分兑换
	 */
	public Integer getExchangeIntegral() {
		return exchangeIntegral;
	}
	/**
	 * 设置：商品关键词
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * 获取：商品关键词
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * 设置：商品简单描述
	 */
	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}
	/**
	 * 获取：商品简单描述
	 */
	public String getGoodsRemark() {
		return goodsRemark;
	}
	/**
	 * 设置：商品上传原始图
	 */
	public void setOriginalImg(String originalImg) {
		this.originalImg = originalImg;
	}
	/**
	 * 获取：商品上传原始图
	 */
	public String getOriginalImg() {
		return originalImg;
	}
	/**
	 * 设置：是否为虚拟商品 1是，0否
	 */
	public void setIsVirtual(Integer isVirtual) {
		this.isVirtual = isVirtual;
	}
	/**
	 * 获取：是否为虚拟商品 1是，0否
	 */
	public Integer getIsVirtual() {
		return isVirtual;
	}
	/**
	 * 设置：虚拟商品有效期
	 */
	public void setVirtualIndate(Integer virtualIndate) {
		this.virtualIndate = virtualIndate;
	}
	/**
	 * 获取：虚拟商品有效期
	 */
	public Integer getVirtualIndate() {
		return virtualIndate;
	}
	/**
	 * 设置：虚拟商品购买上限
	 */
	public void setVirtualLimit(Integer virtualLimit) {
		this.virtualLimit = virtualLimit;
	}
	/**
	 * 获取：虚拟商品购买上限
	 */
	public Integer getVirtualLimit() {
		return virtualLimit;
	}
	/**
	 * 设置：是否允许过期退款， 1是，0否
	 */
	public void setVirtualRefund(Integer virtualRefund) {
		this.virtualRefund = virtualRefund;
	}
	/**
	 * 获取：是否允许过期退款， 1是，0否
	 */
	public Integer getVirtualRefund() {
		return virtualRefund;
	}
	/**
	 * 设置：0下架1上架2违规下架
	 */
	public void setIsOnSale(Integer isOnSale) {
		this.isOnSale = isOnSale;
	}
	/**
	 * 获取：0下架1上架2违规下架
	 */
	public Integer getIsOnSale() {
		return isOnSale;
	}
	/**
	 * 设置：是否包邮0否1是
	 */
	public void setIsFreeShipping(Integer isFreeShipping) {
		this.isFreeShipping = isFreeShipping;
	}
	/**
	 * 获取：是否包邮0否1是
	 */
	public Integer getIsFreeShipping() {
		return isFreeShipping;
	}
	/**
	 * 设置：商品上架时间
	 */
	public void setOnTime(Integer onTime) {
		this.onTime = onTime;
	}
	/**
	 * 获取：商品上架时间
	 */
	public Integer getOnTime() {
		return onTime;
	}
	/**
	 * 设置：商品排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：商品排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：是否推荐
	 */
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	/**
	 * 获取：是否推荐
	 */
	public Integer getIsRecommend() {
		return isRecommend;
	}
	/**
	 * 设置：是否新品
	 */
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	/**
	 * 获取：是否新品
	 */
	public Integer getIsNew() {
		return isNew;
	}
	/**
	 * 设置：是否热卖
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：是否热卖
	 */
	public Integer getIsHot() {
		return isHot;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setLastUpdate(Integer lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Integer getLastUpdate() {
		return lastUpdate;
	}
	/**
	 * 设置：商品所属类型id，取值表goods_type的id
	 */
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：商品所属类型id，取值表goods_type的id
	 */
	public Integer getGoodsType() {
		return goodsType;
	}
	/**
	 * 设置：购买商品赠送积分
	 */
	public void setGiveIntegral(Integer giveIntegral) {
		this.giveIntegral = giveIntegral;
	}
	/**
	 * 获取：购买商品赠送积分
	 */
	public Integer getGiveIntegral() {
		return giveIntegral;
	}
	/**
	 * 设置：商品销量
	 */
	public void setSalesSum(Integer salesSum) {
		this.salesSum = salesSum;
	}
	/**
	 * 获取：商品销量
	 */
	public Integer getSalesSum() {
		return salesSum;
	}
	/**
	 * 设置：0默认1抢购2团购3优惠促销
	 */
	public void setPromType(Integer promType) {
		this.promType = promType;
	}
	/**
	 * 获取：0默认1抢购2团购3优惠促销
	 */
	public Integer getPromType() {
		return promType;
	}
	/**
	 * 设置：优惠活动id
	 */
	public void setPromId(Integer promId) {
		this.promId = promId;
	}
	/**
	 * 获取：优惠活动id
	 */
	public Integer getPromId() {
		return promId;
	}
	/**
	 * 设置：佣金用于分销分成
	 */
	public void setDistribut(BigDecimal distribut) {
		this.distribut = distribut;
	}
	/**
	 * 获取：佣金用于分销分成
	 */
	public BigDecimal getDistribut() {
		return distribut;
	}
	/**
	 * 设置：商家店铺ID
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	/**
	 * 获取：商家店铺ID
	 */
	public Integer getStoreId() {
		return storeId;
	}
	/**
	 * 设置：SPU
	 */
	public void setSpu(String spu) {
		this.spu = spu;
	}
	/**
	 * 获取：SPU
	 */
	public String getSpu() {
		return spu;
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
	 * 设置：0待审核1审核通过2审核失败
	 */
	public void setGoodsState(Integer goodsState) {
		this.goodsState = goodsState;
	}
	/**
	 * 获取：0待审核1审核通过2审核失败
	 */
	public Integer getGoodsState() {
		return goodsState;
	}
	/**
	 * 设置：违规下架原因
	 */
	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}
	/**
	 * 获取：违规下架原因
	 */
	public String getCloseReason() {
		return closeReason;
	}
	/**
	 * 设置：供应商ID
	 */
	public void setSuppliersId(Integer suppliersId) {
		this.suppliersId = suppliersId;
	}
	/**
	 * 获取：供应商ID
	 */
	public Integer getSuppliersId() {
		return suppliersId;
	}
	/**
	 * 设置：配送物流shipping_area_id,以逗号分隔
	 */
	public void setShippingAreaIds(String shippingAreaIds) {
		this.shippingAreaIds = shippingAreaIds;
	}
	/**
	 * 获取：配送物流shipping_area_id,以逗号分隔
	 */
	public String getShippingAreaIds() {
		return shippingAreaIds;
	}
	/**
	 * 设置：1:第三方自营店,2:总平台自营店
	 */
	public void setIsOwnShop(Integer isOwnShop) {
		this.isOwnShop = isOwnShop;
	}
	/**
	 * 获取：1:第三方自营店,2:总平台自营店
	 */
	public Integer getIsOwnShop() {
		return isOwnShop;
	}
}
