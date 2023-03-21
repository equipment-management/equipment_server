package com.dgsw.equipment.global.infra.oauth.dodam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter @NoArgsConstructor
@AllArgsConstructor
public class DAuthResponse implements Serializable {

    private String accessToken;
    private String refreshToken;

}
