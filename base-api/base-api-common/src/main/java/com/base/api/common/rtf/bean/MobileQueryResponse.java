package com.base.api.common.rtf.bean;

/**
 * 手机号查询 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class MobileQueryResponse extends RtfBaseResponse {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 处理时间
     */
    private String processTime;

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "MobileQueryResponse{" +
                "contracts='" + contracts + '\'' +
                ", mobile=" + mobile +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
