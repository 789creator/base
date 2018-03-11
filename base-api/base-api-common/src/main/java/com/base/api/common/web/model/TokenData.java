package com.base.api.common.web.model;

import com.base.api.common.utils.StrUtils;

/**
 * Created by xiaohaizi on 2017/6/24.
 */
public class TokenData {

    /**用户手机**/
    private String mobile;
    /**用户ID**/
    private Long id;
    /**设备类型**/
    private int client;
    /**头像**/
    private String avatars;
    /**实名状态**/
    private int realNameStatus;
    /**token版本**/
    private String v;

    /**
     * 请求过来的Token
     */
    private String token;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        if(id == null)return 0L;
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public int getRealNameStatus() {
        return realNameStatus;
    }

    public void setRealNameStatus(int realNameStatus) {
        this.realNameStatus = realNameStatus;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 检查Token是否有效
     * @param token
     * @return
     */
    public boolean checkToken(String token){
        if(StrUtils.isNotEmpty(token)){
            if(!getToken().equals(token)){
                return false;
            }
        }
        return true;
    }
}
