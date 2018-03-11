package com.base.api.common.rtf.bean;

/**
 * 个人一键签约 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class ImmediateSignResponse extends RtfBaseResponse {

    /**
     * 签约订单号
     */
    private String orderNo;
    /**
     * 协议号
     */
    private String contracts;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户身份证号
     */
    private String userIdentity;
    /**
     * 用户手机号
     */
    private String userMobile;
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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
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
        return "ImmediateSignResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", contracts='" + contracts + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
