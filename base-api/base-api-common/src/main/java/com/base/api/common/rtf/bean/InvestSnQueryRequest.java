package com.base.api.common.rtf.bean;

/**
 * 流水号查询 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class InvestSnQueryRequest extends RtfBaseRequest {

    /**
     * 业务流水号
     */
    private String serialNo;
    /**
     * 处理时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String queryTime;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }
}
