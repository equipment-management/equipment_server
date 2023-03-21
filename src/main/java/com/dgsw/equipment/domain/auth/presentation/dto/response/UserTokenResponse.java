package com.dgsw.equipment.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class UserTokenResponse {

    private String accessToken;
    private String refreshToken;
    private UserResponse user;

}
