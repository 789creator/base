package com.base.api.common.rtf.bean;

/**
 * 一键投标（重发短信） 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeyInvestSmsAgainResponse extends RtfBaseResponse {

    /**
     * 订单号
     */
    private String orderNo;
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
        return "OneKeyInvestSmsAgainResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
