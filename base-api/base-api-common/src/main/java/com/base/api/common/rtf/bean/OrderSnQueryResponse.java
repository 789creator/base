package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 订单号查询（单笔） 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OrderSnQueryResponse extends RtfBaseResponse {

    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 实际投标金额
     */
    private BigDecimal realAmount;
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

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
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
        return "OrderSnQueryResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", realAmount=" + realAmount +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
