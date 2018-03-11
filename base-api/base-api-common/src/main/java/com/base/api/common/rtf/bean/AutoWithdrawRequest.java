package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 自动提现 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class AutoWithdrawRequest extends RtfBaseRequest {

    /**
     * 提现订单号
     */
    private String orderNo;
    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 手续费
     */
    private BigDecimal charge;
    /**
     * 银行卡编号
     */
    private String bankCard;
    /**
     * 设备通道
     */
    private String busway;
    /**
     * 通知URL
     */
    private String notifyUrl;
    /**
     * 备注
     */
    private String remark;
    /**
     * 处理时间
     */
    private String applyTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBusway() {
        return busway;
    }

    public void setBusway(String busway) {
        this.busway = busway;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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
