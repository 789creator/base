package com.base.api.common.rtf.bean;

/**
 * 提现查询 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class WithdrawQueryRequest extends RtfBaseRequest {

    /**
     * 商户订单号
     */
    private String orderNo;
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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
