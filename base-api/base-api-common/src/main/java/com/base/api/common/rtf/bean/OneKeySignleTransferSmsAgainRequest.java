package com.base.api.common.rtf.bean;

/**
 * 一键转让（重发短信） 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeySignleTransferSmsAgainRequest extends RtfBaseRequest {

    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 承接方协议号
     */
    private String contracts;
    /**
     * 终端信息（手机IMEI地址、MAC地址、UUID）
     */
    private String terminalInfo;
    /**
     * 用户IP
     */
    private String memberIp;
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

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
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
