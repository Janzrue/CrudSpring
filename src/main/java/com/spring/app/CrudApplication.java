package com.spring.app;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI().info(new Info()
				.title("Janzrue Spring Boot 3 API")
				.version("1.0")
				.description("Sample APIREST app with SpringBoot 3 and Swagger")
				.termsOfService("https://smartbear.com/terms-of-use/")
				.license(new License().name("Apache 3.0").url("https://springdoc.org/"))
		);
	}
}
