package com.base.sys.dao.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户组织关联表
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@TableName("upms_user_organization")
public class UpmsUserOrganization extends Model<UpmsUserOrganization> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_organization_id", type = IdType.AUTO)
    private Integer userOrganizationId;
    /**
     * 用户编号
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 组织编号
     */
    @TableField("organization_id")
    private Integer organizationId;


    public Integer getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(Integer userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    protected Serializable pkVal() {
        return this.userOrganizationId;
    }

    @Override
    public String toString() {
        return "UpmsUserOrganization{" +
        ", userOrganizationId=" + userOrganizationId +
        ", userId=" + userId +
        ", organizationId=" + organizationId +
        "}";
    }
}
