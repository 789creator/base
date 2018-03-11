package com.base.api.common.rtf.bean;

/**
 * 签约手机号修改（短信） 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class MobileModifyRequest extends RtfBaseRequest {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 新手机号
     */
    private String mobile;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 申请时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String applyTime;

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
