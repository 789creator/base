package com.base.api.common.rtf.bean;

/**
 * 快捷充值确认 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class QuickRechargeConfirmRequest extends RtfBaseRequest {

    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 短信验证码
     */
    private String checkCode;
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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
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
