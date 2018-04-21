package com.base.api.dao.model;


import com.base.api.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Member extends BaseDomain<Long> implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 姓名
     */
    private String name;
    
    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;

    private Integer status;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 渠道标识
     */
    private String channel;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 登录密码
     */
    @Column(name = "login_pwd")
    private String loginPwd;


    /**
     * 支付密码
     */
    @Column(name = "pay_pwd")
    private String payPwd;

    /**
     * ip
     */
    private String ip;

    /**
     * 注册来源：0未知，1、IOS，2、Android，3、WAP，4、PC
     */
    @Column(name = "reg_source")
    private Integer regSource;

    /**
     * 实名认证状态，0：未认证 1：已认证
     */
    @Column(name = "real_name_status")
    private Integer realNameStatus;
    /***
     * 奖励金
     */
    @Column(name = "trial_amount")
    private BigDecimal trialAmount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getTrialAmount() {
        return trialAmount;
    }

    public void setTrialAmount(BigDecimal trialAmount) {
        this.trialAmount = trialAmount;
    }

    /**
     * 获取渠道标识
     *
     * @return channel - 渠道标识
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置渠道标识
     *
     * @param channel 渠道标识
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取登录密码
     *
     * @return login_pwd - 登录密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 设置登录密码
     *
     * @param loginPwd 登录密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    /**
     * 获取支付密码
     *
     * @return pay_pwd - 支付密码
     */
    public String getPayPwd() {
        return payPwd;
    }

    /**
     * 设置支付密码
     *
     * @param payPwd 支付密码
     */
    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    /**
     * 获取注册来源：0未知，1、IOS，2、Android，3、WAP，4、PC
     *
     * @return reg_source - 注册来源：0未知，1、IOS，2、Android，3、WAP，4、PC
     */
    public Integer getRegSource() {
        return regSource;
    }

    /**
     * 设置注册来源：0未知，1、IOS，2、Android，3、WAP，4、PC
     *
     * @param regSource 注册来源：0未知，1、IOS，2、Android，3、WAP，4、PC
     */
    public void setRegSource(Integer regSource) {
        this.regSource = regSource;
    }

    /**
     * 获取实名认证状态，0：未认证 1：已认证
     *
     * @return real_name_status - 实名认证状态，0：未认证 1：已认证
     */
    public Integer getRealNameStatus() {
        return realNameStatus;
    }

    /**
     * 设置实名认证状态，0：未认证 1：已认证
     *
     * @param realNameStatus 实名认证状态，0：未认证 1：已认证
     */
    public void setRealNameStatus(Integer realNameStatus) {
        this.realNameStatus = realNameStatus;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getLoginPwd() == null ? other.getLoginPwd() == null : this.getLoginPwd().equals(other.getLoginPwd()))
            && (this.getPayPwd() == null ? other.getPayPwd() == null : this.getPayPwd().equals(other.getPayPwd()))
            && (this.getRegSource() == null ? other.getRegSource() == null : this.getRegSource().equals(other.getRegSource()))
            && (this.getRealNameStatus() == null ? other.getRealNameStatus() == null : this.getRealNameStatus().equals(other.getRealNameStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getLoginPwd() == null) ? 0 : getLoginPwd().hashCode());
        result = prime * result + ((getPayPwd() == null) ? 0 : getPayPwd().hashCode());
        result = prime * result + ((getRegSource() == null) ? 0 : getRegSource().hashCode());
        result = prime * result + ((getRealNameStatus() == null) ? 0 : getRealNameStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    public Member id(Long value) {
        this.id = value;
        return this;
    }

    public Member name(String value) {
        this.name = value;
        return this;
    }

    public Member idCard(String value) {
        this.idCard = value;
        return this;
    }

    public Member status(Integer value) {
        this.status = value;
        return this;
    }

    public Member mobile(String value) {
        this.mobile = value;
        return this;
    }

    public Member sex(Integer value) {
        this.sex = value;
        return this;
    }

    public Member loginPwd(String value) {
        this.loginPwd = value;
        return this;
    }

    public Member payPwd(String value) {
        this.payPwd = value;
        return this;
    }

    public Member regSource(Integer value) {
        this.regSource = value;
        return this;
    }

    public Member realNameStatus(Integer value) {
        this.realNameStatus = value;
        return this;
    }

    public Member createTime(Date value) {
        this.createTime = value;
        return this;
    }

    public Member updateTime(Date value) {
        this.updateTime = value;
        return this;
    }
}