package com.base.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BaseSysServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BaseSysServerApplication.class, args);
	}
}
