package com.base.api.common.rtf.bean;

/**
 * 银行卡绑定 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class BankCardAddResponse extends RtfBaseResponse {

    /**
     * 签约订单号(确保在商户系统中唯一由数字和字母组成)
     */
    private String orderNo;
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
        return "BankCardAddResponse{" +
                "orderNo='" + orderNo + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
