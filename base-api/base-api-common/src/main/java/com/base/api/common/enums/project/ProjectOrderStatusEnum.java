package com.base.api.common.enums.project;

/**
 * Created by huang_sq on 2017/6/26.
 */
public enum ProjectOrderStatusEnum {

    /*待还款**/
    TO_BE_REAPY(1, "待还款"),
    /**还款中**/
    REPAYING(2, "还款中"),
    /**已还款***/
    REPAYED(3, "已还款");

    private Integer type;
    private String desc;

    private ProjectOrderStatusEnum(Integer type, String desc ) {
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
