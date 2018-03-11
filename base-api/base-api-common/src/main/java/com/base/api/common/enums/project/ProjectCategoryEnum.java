package com.base.api.common.enums.project;

/**
 * Created by huang_sq on 2017/6/26.
 */
public enum ProjectCategoryEnum {

    /*新手标**/
    NOOB_ENJOY(1, "新手专享"),
    /**
     * 活动标
     */
    ACTIVITY_PROJECT(2, "活动标"),
    /**
     * 普通标
     **/
    COMMON_PROJECT(3, "普通标");

    private Integer type;
    private String desc;

    private ProjectCategoryEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

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
}
