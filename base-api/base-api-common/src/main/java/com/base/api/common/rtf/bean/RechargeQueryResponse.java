package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 充值查询 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class RechargeQueryResponse extends RtfBaseResponse {

    /**
     * 充值订单号
     */
    private String orderNo;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 手续费
     */
    private BigDecimal charge;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
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
        return "RechargeQueryResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", charge=" + charge +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
