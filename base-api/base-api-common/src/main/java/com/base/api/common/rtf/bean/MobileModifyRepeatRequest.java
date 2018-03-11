package com.base.api.common.rtf.bean;

/**
 * 签约手机号修改(重复短信) 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class MobileModifyRepeatRequest extends RtfBaseRequest {

    /**
     * 订单号（与签约手机号修改(短信)接口保持一致）
     */
    private String orderNo;
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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
