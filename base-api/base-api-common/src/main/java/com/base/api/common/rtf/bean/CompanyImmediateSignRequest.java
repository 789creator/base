package com.base.api.common.rtf.bean;

/**
 * 企业一键签约 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class CompanyImmediateSignRequest extends RtfBaseRequest {

    /**
     * 签约订单号(确保在商户系统中唯一由数字和字母组成)
     */
    private String orderNo;
    /**
     * 法人代表姓名
     */
    private String corpName;
    /**
     * 法人身份证号
     */
    private String corpIdentity;
    /**
     * 企业名称
     */
    private String comName;
    /**
     * 组织机构代码/社会征信号
     */
    private String comLicense;
    /**
     * 起始日期（必须是企业组织机构证起始日，YYYYMMDD）
     */
    private String licStartDate;
    /**
     * 截止日期(必须是企业组织机构证截止日，YYYYMMDD)
     */
    private String licEndDate;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 企业邮箱
     */
    private String email;
    /**
     * 设备通道(00：PC端；01：手机端；02：Pad端；03：其它)
     */
    private String busway;
    /**
     * 回调URL(页面跳转商户站点通知业务处理结果的Url地址)
     */
    private String returnUrl;
    /**
     * 通知URL(系统后台自动通知商户业务处理结果的Url地址)
     */
    private String notifyUrl;
    /**
     * 备注
     */
    private String remark;
    /**
     * 申请时间(商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss)
     */
    private String applyTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpIdentity() {
        return corpIdentity;
    }

    public void setCorpIdentity(String corpIdentity) {
        this.corpIdentity = corpIdentity;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComLicense() {
        return comLicense;
    }

    public void setComLicense(String comLicense) {
        this.comLicense = comLicense;
    }

    public String getLicStartDate() {
        return licStartDate;
    }

    public void setLicStartDate(String licStartDate) {
        this.licStartDate = licStartDate;
    }

    public String getLicEndDate() {
        return licEndDate;
    }

    public void setLicEndDate(String licEndDate) {
        this.licEndDate = licEndDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusway() {
        return busway;
    }

    public void setBusway(String busway) {
        this.busway = busway;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
