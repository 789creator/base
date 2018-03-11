package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 快捷充值签约 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class QuickRechargeRequest extends RtfBaseRequest {

    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 银行卡卡号
     */
    private String bankCard;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 证件类型(证件类型，暂时只支持身份证（01）)
     */
    private String certType;
    /**
     * 用户身份证号
     */
    private String userIdentity;
    /**
     * 用户手机号(必须是用户自己的手机号信息（注意是银行卡预留手机号）)
     */
    private String userMobile;
    /**
     * 交易币种(默认人民币（仅支持人民币cny）)
     */
    private String currency;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 手续费
     */
    private BigDecimal charge;
    /**
     * 设备通道(00：PC端；01：手机端；02：Pad端；03：其它)
     */
    private String busway;
    /**
     * 终端信息
     */
    private String terminalInfo;
    /**
     * 用户IP
     */
    private String memberIp;
    /**
     * 通知URL
     */
    private String notifyUrl;
    /**
     * 备注
     */
    private String remark;
    /**
     * 申请时间
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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getBusway() {
        return busway;
    }

    public void setBusway(String busway) {
        this.busway = busway;
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public String getMemberIp() {
        return memberIp;
    }

    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp;
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
