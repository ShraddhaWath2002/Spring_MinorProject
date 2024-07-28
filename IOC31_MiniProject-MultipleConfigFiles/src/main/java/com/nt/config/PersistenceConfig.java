package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value = "com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	
	public DriverManagerDataSource createDMDS() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		dmds.setUrl(env.getRequiredProperty("jdbc.url"));
		dmds.setUsername(env.getRequiredProperty("jdbc.user"));
		dmds.setPassword(env.getRequiredProperty("jdbc.password"));
		return dmds;
	}
}
