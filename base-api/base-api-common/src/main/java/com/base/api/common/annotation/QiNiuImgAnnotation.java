package com.base.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 存放在七牛的图片
 * @author xiaohaizi
 * @date   2017年4月9日 下午3:00:48
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface QiNiuImgAnnotation {

}
