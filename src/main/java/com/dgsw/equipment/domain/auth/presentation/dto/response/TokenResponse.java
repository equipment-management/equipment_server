package com.dgsw.equipment.domain.auth.presentation.dto.response;

import com.dgsw.equipment.domain.user.presentation.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class TokenResponse {

    private String accessToken;
    private String refreshToken;
    private UserResponse user;

}
