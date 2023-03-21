package com.dgsw.equipment.global.infra.oauth.dodam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Builder
@AllArgsConstructor
public class DAuthRequest {

    private String code;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

}
