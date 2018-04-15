package com.base.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 图片的网络路径(URL)
 * @author Saleson Lee.
 * @date 2016年4月6日
 * @time 下午3:37:23
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageWebUrlAnnotation {

}
