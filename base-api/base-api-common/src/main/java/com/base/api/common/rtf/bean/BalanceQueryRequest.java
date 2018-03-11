package com.base.api.common.rtf.bean;

/**
 * 余额查询 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class BalanceQueryRequest extends RtfBaseRequest {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 处理时间
     */
    private String queryTime;

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }
}
