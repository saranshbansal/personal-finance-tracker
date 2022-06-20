package com.banking.financeapp.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnProperty(name = "springdoc.api-docs.enabled", matchIfMissing = true)
@Configuration
public class OpenApiConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("Finance app")
				.addOpenApiMethodFilter(method -> method.getDeclaringClass().isAnnotationPresent(RestController.class))
				.build();
	}

	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info()
				.title("REST APIs for finance app")
				.termsOfService("http://localhost:8080")
				.license(new License().name("Apache Licence Version 2.0"))
				.version("2.0")
		);
	}
}
