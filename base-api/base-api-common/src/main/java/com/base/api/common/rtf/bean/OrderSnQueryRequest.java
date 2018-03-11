package com.base.api.common.rtf.bean;

/**
 * 订单号查询（单笔） 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OrderSnQueryRequest extends RtfBaseRequest {

    /**
     * 业务订单号【对应发标、投标订单号】
     */
    private String orderNo;
    /**
     * 处理时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
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
