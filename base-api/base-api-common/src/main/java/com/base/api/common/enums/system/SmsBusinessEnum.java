/**
 * @author zhubingbing
 * @date 2017年3月23日 下午2:41:11
 */
package com.base.api.common.enums.system;


/**
 * created by huang_sq
 */
public enum SmsBusinessEnum {

    /**
     * 登录注册通过手机验证码
     */
    LOGIN_OR_REGISTER(1, "loginOrRegister"),

    /**
     * 找回交易密码
     */
    FIND_PAYMENT_PASSWORD(2, "findPaymentPassword"),

    /**
     * 邀请好友注册
     */
    INVITE_FRIEND(3, "inviteFriend");


    private String desc;

    private Integer code;

    SmsBusinessEnum(Integer code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    /**
     * 获得短信业务类型
     * @param code
     * @return
     */
    public static SmsBusinessEnum getSMSBusinessByCode(int code){
        for(SmsBusinessEnum sms : values()){
            if(sms.getCode().intValue() == code) {
                return sms;
            }
        }
        return null;
    }
}
