package com.dgsw.equipment.global.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "app.dauth")
public class AppProperties {

    private String authUrl;
    private String openUrl;
    private String clientId;
    private String clientSecret;

}
