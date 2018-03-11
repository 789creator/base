package com.base.sys.dao.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 代码生成表
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@TableName("js_gen_table")
public class GenTable extends Model<GenTable> {

    private static final long serialVersionUID = 1L;

    /**
     * 表名
     */
    @TableId("table_name")
    private String tableName;
    /**
     * 实体类名称
     */
    @TableField("class_name")
    private String className;
    /**
     * 表说明
     */
    private String comments;
    /**
     * 关联父表的表名
     */
    @TableField("parent_table_name")
    private String parentTableName;
    /**
     * 本表关联父表的外键名
     */
    @TableField("parent_table_fk_name")
    private String parentTableFkName;
    /**
     * 使用的模板
     */
    @TableField("tpl_category")
    private String tplCategory;
    /**
     * 生成包路径
     */
    @TableField("package_name")
    private String packageName;
    /**
     * 生成模块名
     */
    @TableField("module_name")
    private String moduleName;
    /**
     * 生成子模块名
     */
    @TableField("sub_module_name")
    private String subModuleName;
    /**
     * 生成功能名
     */
    @TableField("function_name")
    private String functionName;
    /**
     * 生成功能名（简写）
     */
    @TableField("function_name_simple")
    private String functionNameSimple;
    /**
     * 生成功能作者
     */
    @TableField("function_author")
    private String functionAuthor;
    /**
     * 生成基础路径
     */
    @TableField("gen_base_dir")
    private String genBaseDir;
    /**
     * 其它生成选项
     */
    private String options;
    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField("update_date")
    private Date updateDate;
    /**
     * 备注信息
     */
    private String remarks;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getParentTableName() {
        return parentTableName;
    }

    public void setParentTableName(String parentTableName) {
        this.parentTableName = parentTableName;
    }

    public String getParentTableFkName() {
        return parentTableFkName;
    }

    public void setParentTableFkName(String parentTableFkName) {
        this.parentTableFkName = parentTableFkName;
    }

    public String getTplCategory() {
        return tplCategory;
    }

    public void setTplCategory(String tplCategory) {
        this.tplCategory = tplCategory;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionNameSimple() {
        return functionNameSimple;
    }

    public void setFunctionNameSimple(String functionNameSimple) {
        this.functionNameSimple = functionNameSimple;
    }

    public String getFunctionAuthor() {
        return functionAuthor;
    }

    public void setFunctionAuthor(String functionAuthor) {
        this.functionAuthor = functionAuthor;
    }

    public String getGenBaseDir() {
        return genBaseDir;
    }

    public void setGenBaseDir(String genBaseDir) {
        this.genBaseDir = genBaseDir;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    protected Serializable pkVal() {
        return this.tableName;
    }

    @Override
    public String toString() {
        return "GenTable{" +
        ", tableName=" + tableName +
        ", className=" + className +
        ", comments=" + comments +
        ", parentTableName=" + parentTableName +
        ", parentTableFkName=" + parentTableFkName +
        ", tplCategory=" + tplCategory +
        ", packageName=" + packageName +
        ", moduleName=" + moduleName +
        ", subModuleName=" + subModuleName +
        ", functionName=" + functionName +
        ", functionNameSimple=" + functionNameSimple +
        ", functionAuthor=" + functionAuthor +
        ", genBaseDir=" + genBaseDir +
        ", options=" + options +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", remarks=" + remarks +
        "}";
    }
}
