package com.base.api.common.enums.acitivity;

/**
 * Created by huang_sq on 2017/7/25.
 */
public enum TurntableProductEnum {

    CASH(1,"现金"),

    COUPON(2, "红包"),

    PHONE_FARE(3, "话费");


    private Integer type;

    private String desc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    TurntableProductEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static TurntableProductEnum getTurntableProductEnum(Integer type) {
        for (TurntableProductEnum temp : TurntableProductEnum.values()) {
            if (temp.getType() == type) {
                return temp;
            }
        }
        return null;
    }

}
