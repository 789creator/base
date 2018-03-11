package com.base.api.common.rtf.bean;

/**
 * 企业分账查询 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class SubAccountQueryRequest extends RtfBaseRequest {

    /**
     * 分账订单号
     */
    private String orderNo;
    /**
     * 分账流水号
     */
    private String serialNo;
    /**
     * 处理时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String applyTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
