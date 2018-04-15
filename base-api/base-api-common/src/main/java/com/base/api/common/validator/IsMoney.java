package com.base.api.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**校验money规则  String类型的Money数字校验
 * Created by zhangdaoyin on 2018/1/12.
 */
@Target({ FIELD,METHOD,PARAMETER,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsMoneyValidator.class)
public @interface IsMoney {
    //默认错误消息
    String message() default "您输入的金额不符合规则";
    //分组
    Class<?>[] groups() default { };
    //负载
    Class<? extends Payload>[] payload() default { };
}
