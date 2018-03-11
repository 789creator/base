package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 发标 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class TenderApplyRequest extends RtfBaseRequest {

    /**
     * 发标订单号
     */
    private String orderNo;
    /**
     * 标的号
     */
    private String tenderNo;
    /**
     * 标的名称
     */
    private String tenderName;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 利率
     */
    private BigDecimal rate;
    /**
     * 借款期数
     */
    private Integer debitTerm;
    /**
     * 期数类型(年：0，月：1，日：2)
     */
    private String debitType;
    /**
     * 还款日期
     * (日期格式：YYYYMMDD 如发标时不能确定 则由发标日期+募集期+借款期限 推算预计首次还款日)
     */
    private String repayDate;
    /**
     * 投标截止日期(日期格式：YYYYMMDD)
     */
    private String expiryDate;
    /**
     * 借款方协议号
     */
    private String debitContracts;
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

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getDebitTerm() {
        return debitTerm;
    }

    public void setDebitTerm(Integer debitTerm) {
        this.debitTerm = debitTerm;
    }

    public String getDebitType() {
        return debitType;
    }

    public void setDebitType(String debitType) {
        this.debitType = debitType;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDebitContracts() {
        return debitContracts;
    }

    public void setDebitContracts(String debitContracts) {
        this.debitContracts = debitContracts;
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
