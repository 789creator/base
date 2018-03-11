package com.base.api.common.rtf.bean;

/**
 * 企业分账查询 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class SubAccountQueryResponse extends RtfBaseResponse {

    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 分账明细
     *
     * 分账明细格式  金额以分为单位
     * {"serialNo":"9876554321","payeeContracts":"RB150814LXP9CH9U","amount":10100,"remark":"分账","resultCode":"0000"}
     */
    private String subDetails;
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

    public String getSubDetails() {
        return subDetails;
    }

    public void setSubDetails(String subDetails) {
        this.subDetails = subDetails;
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

    @Override
    public String toString() {
        return "SubAccountQueryResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", subDetails='" + subDetails + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
