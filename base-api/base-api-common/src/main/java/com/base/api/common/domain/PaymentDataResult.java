package com.base.api.common.domain;

import java.math.BigDecimal;

/**
 * Created by xiaohaizi on 2017/6/28.
 */
public class PaymentDataResult {

    private String orderNo;

    private String outOrderNo;

    private BigDecimal amount;

    private String remarks;

    private int tradeStatus;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(int tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public boolean isSuccess(){
        if(getTradeStatus() == 1){
            return true;
        }
        return false;
    }
}
