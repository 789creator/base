package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 余额查询 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class BalanceQueryResponse extends RtfBaseResponse {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 账户总额
     */
    private BigDecimal totalAmount;
    /**
     * 可用金额
     */
    private BigDecimal usableAmount;
    /**
     * 投标金额
     */
    private BigDecimal tenderAmount;
    /**
     * 处理时间
     */
    private String processTime;

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(BigDecimal usableAmount) {
        this.usableAmount = usableAmount;
    }

    public BigDecimal getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(BigDecimal tenderAmount) {
        this.tenderAmount = tenderAmount;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "BalanceQueryResponse{" +
                "contracts='" + contracts + '\'' +
                ", totalAmount=" + totalAmount +
                ", usableAmount=" + usableAmount +
                ", tenderAmount=" + tenderAmount +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
