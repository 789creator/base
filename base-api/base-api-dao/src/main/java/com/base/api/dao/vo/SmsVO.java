package com.base.api.dao.vo;


import com.base.api.common.annotation.DecryptionAnnotation;
import com.base.api.common.domain.BaseModel;
import com.base.api.common.validator.IsMobile;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by xiaohaizi on 2017/6/21.
 */
public class SmsVO extends BaseModel {

    @NotBlank(message = "{member.mobile.null}")
    @IsMobile
//    @DecryptionAnnotation
    private String mobile;

    @NotNull(message = "{member.businessType.null}")
    private Integer bizType;

    /**
     * 短信类型：0，普通短信，1语音短信
     */
    private boolean isVoice;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public boolean getIsVoice() {
        return isVoice;
    }

    public void setIsVoice(boolean isVoice) {
        this.isVoice = isVoice;
    }

}
