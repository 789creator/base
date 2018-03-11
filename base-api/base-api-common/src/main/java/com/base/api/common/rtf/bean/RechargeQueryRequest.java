package com.base.api.common.rtf.bean;

/**
 * 充值查询 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class RechargeQueryRequest extends RtfBaseRequest {

    /**
     * 充值订单号
     */
    private String orderNo;
    /**
     * 申请时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String queryTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }
}
