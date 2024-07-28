package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.service")
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
@PropertySource(value = "com/nt/commons/jdbc.properties")
public class ServiceConfig {
	
}
