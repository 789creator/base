package com.base.api.common.web.model;

/**
 * Created by xiaohaizi on 2017/7/15.
 */
public class MemberInfoDataRedis {
    private String mobile;

    private Long memberId;

    private String token;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
