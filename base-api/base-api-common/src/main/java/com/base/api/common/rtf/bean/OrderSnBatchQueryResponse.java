package com.base.api.common.rtf.bean;

/**
 * 订单号查询（批量） 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OrderSnBatchQueryResponse extends RtfBaseResponse {

    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 结果代码
     */
    private String resultCode;
    /**
     * 失败明细
     * [
     * {"errorCode":"03","errorMsg":"转出账户余额不足","serialNo":"TRD201504076619"},
     * {"errorCode":"03","errorMsg":"转出账户余额不足","serialNo":"TRD201504077409"},
     * {"errorCode":"03","errorMsg":"转出账户余额不足","serialNo":"TRI201504072689"}
     * ]
     */
    private String failDetails;
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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getFailDetails() {
        return failDetails;
    }

    public void setFailDetails(String failDetails) {
        this.failDetails = failDetails;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "OrderSnBatchQueryResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", failDetails='" + failDetails + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
