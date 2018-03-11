package com.base.api.common.rtf.bean;

/**
 * 快捷充值签约 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class QuickRechargeResponse extends RtfBaseResponse {

    /**
     * 充值订单号
     */
    private String orderNo;
    /**
     *  绑卡ID
     */
    private String bindId;
    /**
     *  招行银行标识
     */
    private String certificate;
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

    public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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
        return "QuickRechargeResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", bindId='" + bindId + '\'' +
                ", certificate='" + certificate + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
