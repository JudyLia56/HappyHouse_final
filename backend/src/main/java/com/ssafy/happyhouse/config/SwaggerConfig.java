package com.ssafy.happyhouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:9999/happyhouse/swagger-ui/index.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("ssafyHappyHouseBoard")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/happyhouse/**"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Happyhouse API")
				.description("Happyhouse API Reference for Developers")
				.termsOfServiceUrl("https://github.com/")
				.license("진상우 & 신성은")
				.licenseUrl("ssafy@ssafy.com").version("1.0").build();
	}
}
