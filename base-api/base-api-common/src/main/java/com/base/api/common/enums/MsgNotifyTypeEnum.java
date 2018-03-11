package com.base.api.common.enums;

/**
 * 通知类型：0-其它, 1-系统公告，2-操作通知, 3-收益通知, 4-:活动通知
 * Created by huang_sq on 2017/7/24.
 */
public enum MsgNotifyTypeEnum {
    OTHER(0, "其它"),
    SYSTEM(1,"系统公告"),
    OPERATE(2,"操作通知"),
    INCOME(3,"收益通知"),
    ACTIVITY(4,"活动通知");

    MsgNotifyTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

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
}
