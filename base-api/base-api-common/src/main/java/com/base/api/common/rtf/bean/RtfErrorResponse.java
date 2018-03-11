package com.base.api.common.rtf.bean;

/**
 * 异常响应结果
 *
 * @author zhj
 * @date 2017/12/11.
 */
public class RtfErrorResponse {
    /**
     * 签约订单号
     */
    private String orderNo;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 接口名称
     */
    private String service;

    /**
     * 错误信息
     */
    private String errorMsg;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
