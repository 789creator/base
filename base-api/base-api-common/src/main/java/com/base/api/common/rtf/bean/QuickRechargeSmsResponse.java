package com.base.api.common.rtf.bean;

/**
 * 快捷充值重发短信 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class QuickRechargeSmsResponse extends RtfBaseResponse {

    /**
     * 充值订单号
     */
    private String orderNo;
    /**
     *  结果代码
     */
    private String resultCode;
    /**
     *  结果描述
     */
    private String resultMsg;
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

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "QuickRechargeSmsResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
