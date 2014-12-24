package com.augylabs.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value = {@PropertySource("classpath:config.properties")})
@ComponentScan(basePackages = {"com.augylabs"})
public class AppConfig {



}
