package com.banking.financeapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
