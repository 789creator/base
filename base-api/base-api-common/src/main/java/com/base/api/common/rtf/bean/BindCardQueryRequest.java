package com.base.api.common.rtf.bean;

/**
 * 绑卡查询 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class BindCardQueryRequest extends RtfBaseRequest {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 业务类型（W）
     */
    private String type;
    /**
     * 处理时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String applyTime;

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
