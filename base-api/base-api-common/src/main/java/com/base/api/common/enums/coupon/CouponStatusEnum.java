package com.base.api.common.enums.coupon;

/**
 * Created by huang_sq on 2017/6/28.
 * 优惠券状态 1-未领取 2-已领取，未使用 3-已使用 4-未领取，已过期 5-已领取，已过期 6-使用中
 */
public enum CouponStatusEnum {
    NOT_RECIEVE_YET(1, "未领取"),
    RECIEVED_AVAILABLE(2, "已领取，未使用"),
    USED_ALREADY(3, "已使用"),
    NOT_RECIEVIE_EXPIRED(4, "未领取，已过期"),
    RECIEVED_EXPIRED(5, "已领取，已过期"),
    IN_USE(6, "使用中");


    private Integer couponStatus;
    private String desc;

    CouponStatusEnum(Integer couponStatus, String desc) {
        this.desc = desc;
        this.couponStatus = couponStatus;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
