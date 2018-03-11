package com.base.api.common.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by huang_sq on 2017/6/23.
 */
@Component
@PropertySource(value = { "classpath:sms.properties" }, encoding="UTF-8")
public class SmsContentConfig {

    @Value("${loginOrRegister}")
    private  String loginSmsContent;

    @Value("${findPaymentPassword}")
    private  String findPaymentPassword;

    @Value("${inviteFriend}")
    private  String inviteFriend;

    @Value("${voiceSMS}")
    private String voiceSMS;


    public  String getLoginSmsContent() {
        return loginSmsContent;
    }

    public void setLoginSmsContent(String loginSmsContent) {
        this.loginSmsContent = loginSmsContent;
    }

    public String getFindPaymentPassword() {
        return findPaymentPassword;
    }

    public void setFindPaymentPassword(String findPaymentPassword) {
        this.findPaymentPassword = findPaymentPassword;
    }

    public String getInviteFriend() {
        return inviteFriend;
    }

    public void setInviteFriend(String inviteFriend) {
        this.inviteFriend = inviteFriend;
    }

    public String getVoiceSMS() {
        return voiceSMS;
    }

    public void setVoiceSMS(String voiceSMS) {
        this.voiceSMS = voiceSMS;
    }
}
