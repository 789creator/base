package com.base.api.common.rtf.bean;

import java.math.BigDecimal;

/**
 * 自动提现 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class AutoWithdrawResponse extends RtfBaseResponse {

    /**
     * 提现订单号
     */
    private String orderNo;
    /**
     * 结果代码
     */
    private BigDecimal amount;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 提现银行
     */
    private String bankName;
    /**
     * 银行卡信息
     */
    private String bankCard;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
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
}
