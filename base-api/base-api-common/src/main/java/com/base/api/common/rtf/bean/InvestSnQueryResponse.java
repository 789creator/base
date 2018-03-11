package com.base.api.common.rtf.bean;

/**
 * 流水号查询 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class InvestSnQueryResponse extends RtfBaseResponse {

    /**
     * 业务流水号
     */
    private String serialNo;
    /**
     * 结果代码
     */
    private String resultCode;
    /**
     * 处理时间
     */
    private String processTime;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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
        return "InvestSnQueryResponse{" +
                "serialNo='" + serialNo + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
