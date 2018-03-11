package com.base.api.common.rtf.bean;

/**
 * 手机号查询 请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class MobileQueryRequest extends RtfBaseRequest {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 申请时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
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
