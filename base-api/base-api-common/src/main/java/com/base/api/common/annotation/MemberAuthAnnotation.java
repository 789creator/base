package com.base.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 会员权限注解
 * 接口必须登录才可以访问  使用于方法
 * @author xiaohaizi
 * @date   2017年3月10日 上午9:23:57
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberAuthAnnotation {

}
