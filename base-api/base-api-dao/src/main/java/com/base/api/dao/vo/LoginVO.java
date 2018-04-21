package com.base.api.dao.vo;


import com.base.api.common.annotation.DecryptionAnnotation;
import com.base.api.common.domain.BaseModel;
import com.base.api.common.validator.IsMobile;
import com.base.api.common.validator.IsMobileCode;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by xiaohaizi on 2017/6/21.
 */
public class LoginVO extends BaseModel {

//    @DecryptionAnnotation
    @NotBlank(message = "{member.mobile.null}")
    @IsMobile
    private String mobile;

    @NotNull(message="{member.mobileCode.null}")
    @IsMobileCode
    private String code;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
