package com.base.sys.server.config;

import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CacheConfig {
    @Bean(name = {"ehCacheManager"})
    public EhCacheManagerFactoryBean ehCacheManager() {
        EhCacheManagerFactoryBean ehCacheManager = new EhCacheManagerFactoryBean();
        ehCacheManager.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        return ehCacheManager;
    }
}
