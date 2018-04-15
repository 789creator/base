package com.b2cshop.modules.shop.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类
 * 
 * @author zhj
 * @email 
 * @date 2018-03-28 20:00:19
 */
@TableName("b2c_goods_category")
public class GoodsCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品分类id
	 */
	@TableId
	private Integer id;
	/**
	 * 商品分类名称
	 */
	private String name;
	/**
	 * 手机端显示的商品分类名
	 */
	private String mobileName;
	/**
	 * 父id
	 */
	private Integer parentId;
	/**
	 * 家族图谱
	 */
	private String parentIdPath;
	/**
	 * 等级
	 */
	private Integer level;
	/**
	 * 顺序排序
	 */
	private Integer sortOrder;
	/**
	 * 是否显示
	 */
	private Integer isShow;
	/**
	 * 分类图片
	 */
	private String image;
	/**
	 * 是否推荐为热门分类
	 */
	private Integer isHot;
	/**
	 * 分类分组默认0
	 */
	private Integer catGroup;
	/**
	 * 佣金比例
	 */
	private Integer commission;
	/**
	 * 分佣比例用于分销
	 */
	private Integer commissionRate;
	/**
	 * 对应的类型id
	 */
	private Integer typeId;

	/**
	 * 父级名称
	 */
	@TableField(exist = false)
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * 设置：商品分类id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：商品分类id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：商品分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：手机端显示的商品分类名
	 */
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	/**
	 * 获取：手机端显示的商品分类名
	 */
	public String getMobileName() {
		return mobileName;
	}
	/**
	 * 设置：父id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父id
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：家族图谱
	 */
	public void setParentIdPath(String parentIdPath) {
		this.parentIdPath = parentIdPath;
	}
	/**
	 * 获取：家族图谱
	 */
	public String getParentIdPath() {
		return parentIdPath;
	}
	/**
	 * 设置：等级
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：等级
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：顺序排序
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * 获取：顺序排序
	 */
	public Integer getSortOrder() {
		return sortOrder;
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
	/**
	 * 设置：分类图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：分类图片
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：是否推荐为热门分类
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：是否推荐为热门分类
	 */
	public Integer getIsHot() {
		return isHot;
	}
	/**
	 * 设置：分类分组默认0
	 */
	public void setCatGroup(Integer catGroup) {
		this.catGroup = catGroup;
	}
	/**
	 * 获取：分类分组默认0
	 */
	public Integer getCatGroup() {
		return catGroup;
	}
	/**
	 * 设置：佣金比例
	 */
	public void setCommission(Integer commission) {
		this.commission = commission;
	}
	/**
	 * 获取：佣金比例
	 */
	public Integer getCommission() {
		return commission;
	}
	/**
	 * 设置：分佣比例用于分销
	 */
	public void setCommissionRate(Integer commissionRate) {
		this.commissionRate = commissionRate;
	}
	/**
	 * 获取：分佣比例用于分销
	 */
	public Integer getCommissionRate() {
		return commissionRate;
	}
	/**
	 * 设置：对应的类型id
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：对应的类型id
	 */
	public Integer getTypeId() {
		return typeId;
	}
}
