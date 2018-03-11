package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 担保方分账
 * Created by 0 on 2017/12/18.
 */
public class RtfDefrayDetailVO {
    /**
     * 商户流水号
     */
    private String serialNo;


    /**
     * 付款方协议号
     */
    private String payerContracts;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPayerContracts() {
        return payerContracts;
    }

    public void setPayerContracts(String payerContracts) {
        this.payerContracts = payerContracts;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
