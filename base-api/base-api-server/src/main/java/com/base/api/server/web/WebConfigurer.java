package com.base.api.server.web;

import com.base.api.common.annotation.MemberAuthAnnotation;
import com.base.api.common.annotation.ResourceAuthAnnotation;
import com.base.api.common.annotation.SignAnnotation;
import com.base.api.common.annotation.TokenAnnotation;
import com.base.api.common.web.converter.DecryptionConversionServiceFactoryBean;
import com.base.api.common.web.converter.JSONHttpMessageConverter;
import com.base.api.server.web.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 *
 * Created by xiaohaizi on 2017/6/21.
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    TokenHandleInterceptor tokenHandleInterceptor(){
        return new TokenHandleInterceptor();
    }
    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        registry.addInterceptor(new PreHandleInterceptor()).addPathPatterns("/**");

        //基于类的注解，所有方法必须签名、登录才可访问
        ResourceAuthHandleInterceptor rah = new ResourceAuthHandleInterceptor();
        rah.setAnnotationClass(ResourceAuthAnnotation.class);
        rah.setHandlerInterceptor(new AsyncHandlerInterceptor[]{new RequestSignHandleInterceptor(), tokenHandleInterceptor()});
        registry.addInterceptor(rah).addPathPatterns("/**");

        //基于方法的注解，如果登录用户可获取登录用户状态
        ResourceAuthHandleInterceptor rah1 = new ResourceAuthHandleInterceptor();
        rah1.setAnnotationClass(TokenAnnotation.class);
        rah1.setHandlerInterceptor(new AsyncHandlerInterceptor[]{new UserHandleInterceptor()});
        registry.addInterceptor(rah1).addPathPatterns("/**");

        //基于方法的注解，方法必须签名、登录才可访问
        ResourceAuthHandleInterceptor rah2 = new ResourceAuthHandleInterceptor();
        rah2.setAnnotationClass(MemberAuthAnnotation.class);
        rah2.setHandlerInterceptor(new AsyncHandlerInterceptor[]{new RequestSignHandleInterceptor(), tokenHandleInterceptor()});
        registry.addInterceptor(rah2).addPathPatterns("/**");

        //基于方法的注解，方法必须签名通过
        ResourceAuthHandleInterceptor rah3 = new ResourceAuthHandleInterceptor();
        rah3.setAnnotationClass(SignAnnotation.class);
        rah3.setHandlerInterceptor(new AsyncHandlerInterceptor[]{new RequestSignHandleInterceptor()});
        registry.addInterceptor(rah3).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

    /**
     * 自定义转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new JSONHttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new DecryptionConversionServiceFactoryBean());
        super.addFormatters(registry);
    }


}
