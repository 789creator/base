package com.base.api.common.enums.acitivity;

/**
 * Created by huang_sq on 2017/8/15.
 */
public enum  TurntableProductCodeEnum {

//    prize:['100元现金','20元话费','15元红包','10元现金','8元红包','50元红包'],//按顺序共有六个项奖励

    CASH_100(0),
    PHONE_FEE_2O(1),
    COUPON_15(2),
    CASH_10(3),
    COUPON_8(4),
    COUPON_50(5);

    private Integer code;

    TurntableProductCodeEnum(Integer code) {
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
