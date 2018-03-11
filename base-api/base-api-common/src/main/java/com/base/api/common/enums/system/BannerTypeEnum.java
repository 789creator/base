package com.base.api.common.enums.system;

/**
 * Created by huang_sq on 2017/6/28.
 * 0：启动页、1：弹屏、2:首页广告轮播
 */
public enum BannerTypeEnum {
    INITIAL_PAGE(0,"启动页"),
    POP_VIEW(1,"弹屏"),
    INDEX_AD_BANNER(2,"首页广告轮播");


    private Integer bannerType;
    private String desc;

    BannerTypeEnum(Integer bannerType,String desc ) {
        this.desc = desc;
        this.bannerType = bannerType;
    }

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
