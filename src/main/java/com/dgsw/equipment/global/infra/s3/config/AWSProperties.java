package com.dgsw.equipment.global.infra.s3.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "aws")
public class AWSProperties {

    private String accessKey;
    private String secretKey;
    private String region;
    private String bucket;
    private String url;

}