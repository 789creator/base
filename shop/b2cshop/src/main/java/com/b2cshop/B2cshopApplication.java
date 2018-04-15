package com.b2cshop;

import com.b2cshop.datasources.DynamicDataSourceConfig;
import com.b2cshop.datasources.DynamicDataSourceConfig;
import com.b2cshop.datasources.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class B2cshopApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(B2cshopApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(B2cshopApplication.class);
	}
}
