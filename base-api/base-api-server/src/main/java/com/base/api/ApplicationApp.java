package com.base.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by hqm on 2017/6/15.
 */

@SpringBootApplication
@ComponentScan
public class ApplicationApp implements ApplicationListener<ContextRefreshedEvent> {
    
    public static void main(String[] args) {
        SpringApplication.run(ApplicationApp.class,args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    }
}
