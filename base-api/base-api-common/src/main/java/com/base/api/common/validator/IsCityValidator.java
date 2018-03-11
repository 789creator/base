package com.base.api.common.validator;

import com.base.api.common.utils.CityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;

/**
 * 城市校验
 * Created by zhangdaoyin on 2018/1/8.
 */
public class IsCityValidator implements ConstraintValidator<IsCity,String> {
    Logger logger = LoggerFactory.getLogger(IsCityValidator.class);
    @Override
    public void initialize(IsCity constraintAnnotation) {
            //初始化，得到注解数据
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] str = value.split(":");
        if (str.length == 2){
            String province = str[0].trim();
            String city = str[1].trim();
            try {
                return CityUtil.isCityUseable(province,city);
            } catch (IOException e) {
                logger.error("请输入正确地址", e);
            }
        }
        return false;
    }
}
