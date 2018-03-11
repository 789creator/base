package com.base.api.common.rtf.bean;

import com.base.api.common.ConfigUtil;
import com.base.api.common.config.Global;

/**
 * 融托富请求
 *
 * @author zhj
 * @date 2017/12/11
 */
public class RtfBaseRequest {


    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 接口名称
     */
    private String service;

    /**
     * 合作伙伴
     */
    private String partner = ConfigUtil.getInstance().getRtfPartner();

    /**
     * 签名
     */
    private String sign;

    /**
     * 签名方式
     */
    private String signType = "0";


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

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
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
