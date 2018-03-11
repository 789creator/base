package com.base.api.common.rtf.bean;

/**
 * 个人签约查询 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class SignQueryRequest extends RtfBaseRequest {

    /**
     * 签约订单号(确保在商户系统中唯一由数字和字母组成)
     */
    private String orderNo;
    /**
     * 处理时间
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
