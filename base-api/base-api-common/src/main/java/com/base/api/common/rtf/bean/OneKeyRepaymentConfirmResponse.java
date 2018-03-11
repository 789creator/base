package com.base.api.common.rtf.bean;

/**
 * 一键还款（确认） 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeyRepaymentConfirmResponse extends RtfBaseResponse {

    /**
     * 交易订单号
     */
    private String orderNo;
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
        return "TenderApplyResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
