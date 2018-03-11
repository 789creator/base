package com.base.api.common.rtf.bean;

/**
 * 企业签约查询 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class CompanySignQueryResponse extends RtfBaseResponse {

    /**
     * 签约订单号(确保在商户系统中唯一由数字和字母组成)
     */
    private String orderNo;
    /**
     * 企业协议号
     */
    private String contracts;
    /**
     * 结果代码
     * 0000：申请成功
     * 0002：签约成功（审核通过）
     * 0003：签约失败（审核不通过）
     * 0006：再次申请成功（审核拒绝后再申请）
     */
    private String resultCode;
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
     * 组织机构代码
     */
    private String comLicense;

    /**
     * 起始日期
     */
    private String licStartDate;
    /**
     * 截止日期
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
     * 备注
     */
    private String remark;
    /**
     * 处理时间
     */
    private String processTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "CompanySignQueryResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", contracts='" + contracts + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", corpName='" + corpName + '\'' +
                ", corpIdentity='" + corpIdentity + '\'' +
                ", comName='" + comName + '\'' +
                ", comLicense='" + comLicense + '\'' +
                ", licStartDate='" + licStartDate + '\'' +
                ", licEndDate='" + licEndDate + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
