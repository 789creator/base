package com.base.api.common.rtf.bean;

/**
 * 个人一键签约 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class ImmediateSignRequest extends RtfBaseRequest {

    /**
     * 签约订单号(确保在商户系统中唯一由数字和字母组成)
     */
    private String orderNo;
    /**
     * 用户姓名(必须是用户身份证信息名字)
     */
    private String userName;
    /**
     * 用户身份证号(必须是用户真实的身份证信息)
     */
    private String userIdentity;
    /**
     * 用户手机号(必须是用户自己的手机号信息)
     */
    private String userMobile;
    /**
     * 设备通道(00：PC端；01：手机端；02：Pad端；03：其它)
     */
    private String busway;
    /**
     * 是否发送初始交易密码短信(T:发送  F：不发送)
     */
    private String isToSms;
    /**
     * 备注(业务备注信息)
     */
    private String remark;
    /**
     * 申请时间(商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss)
     */
    private String applyTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBusway() {
        return busway;
    }

    public void setBusway(String busway) {
        this.busway = busway;
    }

    public String getIsToSms() {
        return isToSms;
    }

    public void setIsToSms(String isToSms) {
        this.isToSms = isToSms;
    }

    public String getRemark() {
        if (remark == null){
            return "";
        }
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

    @Override
    public String toString() {
        return "ImmediateSignRequest{" +
                "orderNo='" + orderNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", busway='" + busway + '\'' +
                ", isToSms='" + isToSms + '\'' +
                ", remark='" + remark + '\'' +
                ", applyTime='" + applyTime + '\'' +
                '}';
    }
}
