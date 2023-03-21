package com.dgsw.equipment.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("대소고 기자재 API")
                .version("version 1.0")
                .description("대소고 기자재 API 문서");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}