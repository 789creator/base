package com.base.api.common.rtf.bean;

/**
 * 融托富 响应
 *
 * @author zhj
 * @date 2017/12/11
 */
public class RtfBaseResponse {

    /**
     * 版本号
     */
    private String version;

    /**
     * 接口名称
     */
    private String service;

    /**
     * 签名
     */
    private String sign;

    /**
     * 签名方式
     */
    private String signType;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
