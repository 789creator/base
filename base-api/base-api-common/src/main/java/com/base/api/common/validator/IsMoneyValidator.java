package com.base.api.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by zhangdaoyin on 2018/1/12.
 */
public class IsMoneyValidator implements ConstraintValidator<IsMoney,String> {
    @Override
    public void initialize(IsMoney constraintAnnotation) {
        //初始化，得到注解数据
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidatorUtil.checkMoney(value);
    }
}
