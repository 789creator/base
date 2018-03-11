package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 一键投标（短信） 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeyInvestSmsRequest extends RtfBaseRequest {

    /**
     * 投标订单号
     */
    private String orderNo;
    /**
     * 投标的标的号
     */
    private String tenderNo;
    /**
     * 自费金额
     */
    private BigDecimal amount;
    /**
     * 红包/抵用卷
     */
    private BigDecimal couponAmt;
    /**
     * 投资方协议号
     */
    private String investContracts;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCouponAmt() {
        return couponAmt;
    }

    public void setCouponAmt(BigDecimal couponAmt) {
        this.couponAmt = couponAmt;
    }

    public String getInvestContracts() {
        return investContracts;
    }

    public void setInvestContracts(String investContracts) {
        this.investContracts = investContracts;
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
