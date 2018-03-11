package com.base.api.common.enums.system;

import java.util.Objects;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by huang_sq on 2017/7/17.
 */
public enum RiskAssessmentTypeEnum {

    RISK_AVERSION(0, "风险厌恶型"),

    RISK_NUETRAL(1, "风险中性型"),

    RISK_SEEKING(2, "风险偏好型"),;

    RiskAssessmentTypeEnum(Integer type, String desc) {
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

    public static String getEnumDesc(Integer riskType) {
        for (RiskAssessmentTypeEnum typeEnum : RiskAssessmentTypeEnum.values()){
            if (Objects.equals(typeEnum.getType(), riskType)) {
                return typeEnum.getDesc();
            }
        }
        return null;
    }
}
