package com.b2cshop.modules.shop.goods.entity;

import com.b2cshop.modules.shop.goods.vo.SpecValVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhj
 * @email
 * @date 2018-04-01 16:17:09
 */
@TableName("b2c_spec")
public class SpecEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 规格表
     */
    @TableId
    private Integer id;
    /**
     * 规格名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer order;
    /**
     * 是否需要检索
     */
    private Integer searchIndex;
    /**
     * 一级分类
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
     * 规格值类型
     */
    private Integer specValType;
    /**
     * 规格值内容
     */
    private String specVal;

    /**
     * 规格值内容列表集合
     */
    @TableField(exist = false)
    private List<SpecValVo> specValList;

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

    public List<SpecValVo> getSpecValList() {
        return specValList;
    }

    public void setSpecValList(List<SpecValVo> specValList) {
        this.specValList = specValList;
    }

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
     * 设置：规格表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：规格表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：规格名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：规格名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：排序
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 获取：排序
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置：是否需要检索
     */
    public void setSearchIndex(Integer searchIndex) {
        this.searchIndex = searchIndex;
    }

    /**
     * 获取：是否需要检索
     */
    public Integer getSearchIndex() {
        return searchIndex;
    }

    /**
     * 设置：一级分类
     */
    public void setCatId1(Integer catId1) {
        this.catId1 = catId1;
    }

    /**
     * 获取：一级分类
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
     * 设置：规格值类型
     */
    public void setSpecValType(Integer specValType) {
        this.specValType = specValType;
    }

    /**
     * 获取：规格值类型
     */
    public Integer getSpecValType() {
        return specValType;
    }

    /**
     * 设置：规格值内容
     */
    public void setSpecVal(String specVal) {
        this.specVal = specVal;
    }

    /**
     * 获取：规格值内容
     */
    public String getSpecVal() {
        return specVal;
    }
}
