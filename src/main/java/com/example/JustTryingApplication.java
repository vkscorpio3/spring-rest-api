package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@Configuration
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableAutoConfiguration
@ComponentScan
public class JustTryingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustTryingApplication.class, args);
	}
}
