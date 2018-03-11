/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:36:48   
 */  
package com.base.api.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验登录密码
 * @author zhubingbing
 * @date   2017年3月29日 下午5:36:48   
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsLoginPasswordValidator.class)
@Documented
public @interface IsLoginPassword {

    //默认错误消息
    String message() default "请输入正确的登录密码";

    //分组
    Class<?>[] groups() default { };

    //负载
    Class<? extends Payload>[] payload() default { };

}