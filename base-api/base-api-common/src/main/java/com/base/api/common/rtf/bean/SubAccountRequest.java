package com.base.api.common.rtf.bean;

import java.util.List;

/**
 * 企业分账 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class SubAccountRequest extends RtfBaseRequest {

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 分账类型(1：代还款。2：分账。3：其它)
     */
    private String subType;
    /**
     * 分账明细(	分账明细格式:JSON数组)
     * [{"serialNo":"TCS201503252143","payeeContracts":"RB141201K76OUYXG","amount":"100","remark":""}]
     */
    private List<RtfSubDetailVO> subDetails;
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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public List getSubDetails() {
        return subDetails;
    }

    public void setSubDetails(List subDetails) {
        this.subDetails = subDetails;
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
