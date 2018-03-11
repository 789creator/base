package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 一键转让（短信） 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeySignleTransferSmsRequest extends RtfBaseRequest {

    /**
     * 业务订单号
     */
    private String orderNo;
    /**
     * 标的号
     */
    private String tenderNo;
    /**
     * 转让本金
     */
    private BigDecimal transCapital;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 转让方协议号
     */
    private String transContracts;
    /**
     * 承接方协议号
     */
    private String intoContracts;
    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 手续费收取方向(1 收取转让方，2 收取承接方 。手续费不为空时此字段必传,手续费为空时此字段不传)
     */
    private String feeType;
    /**
     * 债转类型(传1表示首次债转，即转让人（transContracts）为tenderNo指代标的原始投资人;传2表示第N次债转,转让人（transContracts）并非原标的投资人)
     */
    private String transferType;
    /**
     * 原投资订单号(若transferType为1时,即首次债转时必传)
     */
    private String investOrder;
    /**
     * 原债转订单号（若transferType 为2时,即N次债转时必传）
     */
    private String orgTransferOrder;
    /**
     * 设备通道
     */
    private String busway;
    /**
     * 备注
     */
    private String remark;
    /**
     * 申请时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String applyTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public BigDecimal getTransCapital() {
        return transCapital;
    }

    public void setTransCapital(BigDecimal transCapital) {
        this.transCapital = transCapital;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransContracts() {
        return transContracts;
    }

    public void setTransContracts(String transContracts) {
        this.transContracts = transContracts;
    }

    public String getIntoContracts() {
        return intoContracts;
    }

    public void setIntoContracts(String intoContracts) {
        this.intoContracts = intoContracts;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getInvestOrder() {
        return investOrder;
    }

    public void setInvestOrder(String investOrder) {
        this.investOrder = investOrder;
    }

    public String getOrgTransferOrder() {
        return orgTransferOrder;
    }

    public void setOrgTransferOrder(String orgTransferOrder) {
        this.orgTransferOrder = orgTransferOrder;
    }

    public String getBusway() {
        return busway;
    }

    public void setBusway(String busway) {
        this.busway = busway;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
