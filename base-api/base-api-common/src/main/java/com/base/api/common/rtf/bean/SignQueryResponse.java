package com.base.api.common.rtf.bean;

/**
 * 个人签约查询 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class SignQueryResponse extends RtfBaseResponse {

    /**
     * 签约订单号(确保在商户系统中唯一由数字和字母组成)
     */
    private String orderNo;
    /**
     * 企业协议号
     */
    private String contracts;
    /**
     * 用户手机号
     */
    private String userMobile;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户身份证号
     */
    private String userIdentity;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 结果代码
     */
    private String resultCode;
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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "SignQueryResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", contracts='" + contracts + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
