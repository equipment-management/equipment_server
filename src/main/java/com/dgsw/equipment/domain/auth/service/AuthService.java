package com.dgsw.equipment.domain.auth.service;

import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.domain.repository.UserRepository;
import com.dgsw.equipment.domain.user.exception.UserNotFoundException;
import com.dgsw.equipment.domain.auth.presentation.dto.request.LoginRequest;
import com.dgsw.equipment.domain.auth.presentation.dto.response.TokenResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.response.DOpenInfoResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.response.DOpenResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.service.DAuthService;
import com.dgsw.equipment.global.security.jwt.JwtProvider;
import com.dgsw.equipment.global.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final DAuthService dAuthService;
    private final JwtProvider jwtProvider;

    @Transactional
    public TokenResponse login(LoginRequest request) {
        DOpenResponse data = dAuthService.getUserInfo(request.getCode()).block();

        if(!userRepository.existsByUniqueId(Objects.requireNonNull(data).getData().getUniqueId()))
            userSignUp(data.getData());

        User user = userRepository.findByUniqueId(data.getData().getUniqueId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return TokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(user.getUniqueId(), user.getRole()))
                .refreshToken(jwtProvider.generateRefreshToken(user.getUniqueId(), user.getRole()))
                .user(ResponseUtil.getUserResponse(user))
                .build();
    }

    private void userSignUp(DOpenInfoResponse info) {
        User user = info.toEntity();
        userRepository.save(user);
    }

}
