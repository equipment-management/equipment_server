package com.dgsw.equipment.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration implements WebFluxConfigurer {

    private final AppProperties appProperties;

    @Bean
    public WebClient dauthAuthClient() {
        return WebClient.create(appProperties.getAuthUrl());
    }

    @Bean
    public WebClient dauthOpenClient() {
        return WebClient.create(appProperties.getOpenUrl());
    }

}