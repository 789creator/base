package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 企业分账明细
 * Created by 0 on 2017/12/15.
 */
public class RtfSubDetailVO {

    /**
     * 分账流水号
     */
    private String serialNo;

    /**
     * 收款方协议号
     */
    private String payeeContracts;

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

    public String getPayeeContracts() {
        return payeeContracts;
    }

    public void setPayeeContracts(String payeeContracts) {
        this.payeeContracts = payeeContracts;
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
