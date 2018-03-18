package com.base.sys.server.config;

import com.base.sys.client.shiro.filter.UpmsAuthenticationFilter;
import com.base.sys.client.shiro.filter.UpmsSessionForceLogoutFilter;
import com.base.sys.client.shiro.listener.UpmsSessionListener;
import com.base.sys.client.shiro.realm.UpmsRealm;
import com.base.sys.client.shiro.session.UpmsSessionDao;
import com.base.sys.client.shiro.session.UpmsSessionFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    //将自己的验证方式加入容器
    @Bean
    public UpmsRealm upmsRealm() {
        UpmsRealm upmsRealm = new UpmsRealm();
        return upmsRealm;
    }

    //    重写authc过滤器
    @Bean
    public UpmsAuthenticationFilter upmsAuthentication() {
        UpmsAuthenticationFilter upmsAuthenticationFilter = new UpmsAuthenticationFilter();
        return upmsAuthenticationFilter;
    }

    //    强制退出会话过滤器
    @Bean
    public UpmsSessionForceLogoutFilter upmsSessionForceLogout() {
        UpmsSessionForceLogoutFilter upmsSessionForceLogoutFilter = new UpmsSessionForceLogoutFilter();
        return upmsSessionForceLogoutFilter;
    }

    //Shiro的Web过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/sso/login");
//        factoryBean.setSuccessUrl();
//        factoryBean.setUnauthorizedUrl();
        HashMap<String, Filter> map = new HashMap<>();
        Map<String, Filter> filters = factoryBean.getFilters();
//        filters.put("authc", upmsAuthenticationFilter);
//        map.put("authc", upmsAuthenticationFilter);
        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();
        filterChainDefinitionManager.put("/sys/**", "authc");
        filterChainDefinitionManager.put("/sys/index", "user");
        filterChainDefinitionManager.put("/druid/**", "user");
        filterChainDefinitionManager.put("/swagger-ui.html", "user");
        filterChainDefinitionManager.put("/static/**", "anon");
        filterChainDefinitionManager.put("/**", "user");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//        factoryBean.setFilterChainDefinitions(filterChainDefinitions);
        return factoryBean;
    }

    //会话DAO，可重写，持久化session
    @Bean
    public UpmsSessionDao sessionDao() {
        UpmsSessionDao sessionDao = new UpmsSessionDao();
        return sessionDao;
    }

    //    会话Cookie模板
    @Bean
    public SimpleCookie sessionIdCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setHttpOnly(true);//不会暴露给客户端
        simpleCookie.setMaxAge(-1);//设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie
        simpleCookie.setName("base-upms-server-session-id");//Cookie名称
        //todo 动态获取Cookie名称
        return simpleCookie;
    }

    @Bean
    public UpmsSessionFactory sessionFactory() {
        UpmsSessionFactory sessionFactory = new UpmsSessionFactory();
        return sessionFactory;
    }

    //会话监听器
    @Bean
    public UpmsSessionListener sessionListener() {
        UpmsSessionListener sessionListener = new UpmsSessionListener();
        return sessionListener;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(UpmsRealm upmsRealm, SessionManager sessionManager, RememberMeManager rememberMeManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(upmsRealm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setRememberMeManager(rememberMeManager);
        // 设置SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }

    //Shiro生命周期处理器
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        LifecycleBeanPostProcessor lifecycleBeanPostProcessor = new LifecycleBeanPostProcessor();
        return lifecycleBeanPostProcessor;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    //开启shiro aop注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        System.out.println("开启了Shiro注解支持");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SessionManager sessionManager(UpmsSessionDao sessionDao, SimpleCookie sessionIdCookie, UpmsSessionListener sessionListener, UpmsSessionFactory sessionFactory) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setGlobalSessionTimeout();
        sessionManager.setSessionDAO(sessionDao);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie);
        sessionManager.setSessionValidationSchedulerEnabled(false);
        ArrayList<SessionListener> sessionListeners = new ArrayList<>();
        sessionListeners.add(sessionListener);
        sessionManager.setSessionListeners(sessionListeners);
        sessionManager.setSessionFactory(sessionFactory);
        return sessionManager;
    }

    //rememberMe管理器
    @Bean
    public RememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        rememberMeManager.setCookie(rememberMeCookie);
        return rememberMeManager;
    }

    //    rememberMe缓存cookie
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setHttpOnly(true);//不会暴露给客户端
        simpleCookie.setMaxAge(-1);//设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie
        //todo 动态获取Cookie名称
        return simpleCookie;
    }

//    @Bean
//    public ShiroDialect shiroDialect() {
//        return new ShiroDialect();
//    }
}
