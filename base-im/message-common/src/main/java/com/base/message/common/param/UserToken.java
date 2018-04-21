package com.base.message.common.param;

import com.base.message.common.code.proto.IMBaseDefine;
import com.base.message.common.code.proto.IMBaseDefine.ClientType;

/**
 * 用户Token <br>
 * 用于后续推送等处理
 * 
 * @author 袁贵
 * @version 1.0
 * @since 1.0
 */
public class UserToken {

    private long UserId;
    private String userToken;
    private IMBaseDefine.ClientType clientType;

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    /**
     * @return the userToken
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * @param userToken the userToken to set
     */
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    /**
     * @return the clientType
     */
    public IMBaseDefine.ClientType getClientType() {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(IMBaseDefine.ClientType clientType) {
        this.clientType = clientType;
    }

}
