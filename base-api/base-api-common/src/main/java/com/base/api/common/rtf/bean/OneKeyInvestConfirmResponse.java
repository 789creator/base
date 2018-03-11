package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 一键投标（确认） 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeyInvestConfirmResponse extends RtfBaseResponse {

    /**
     * 投标订单号
     */
    private String orderNo;
    /**
     * 投标申请总金额
     */
    private BigDecimal amount;
    /**
     * 实际投标金额
     */
    private BigDecimal realAmount;
    /**
     * 结果代码
     * 0000：投标成功
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
        return "OneKeyInvestConfirmResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", realAmount=" + realAmount +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
