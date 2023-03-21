package com.dgsw.equipment.domain.auth.service;

import com.dgsw.equipment.domain.auth.domain.User;
import com.dgsw.equipment.domain.auth.domain.repository.UserRepository;
import com.dgsw.equipment.domain.auth.exception.UserNotFoundException;
import com.dgsw.equipment.domain.auth.presentation.dto.request.UserLoginRequest;
import com.dgsw.equipment.domain.auth.presentation.dto.response.UserTokenResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.response.DOpenInfoResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.response.DOpenResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.service.DAuthService;
import com.dgsw.equipment.global.security.jwt.JwtProvider;
import com.dgsw.equipment.global.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DAuthService dAuthService;
    private final JwtProvider jwtProvider;

    @Transactional
    public UserTokenResponse login(UserLoginRequest request) {
        DOpenResponse data = dAuthService.getUserInfo(request.getCode()).block();

        if(!userRepository.existsByUniqueId(Objects.requireNonNull(data).getData().getUniqueId()))
            userSignUp(data.getData());

        User user = userRepository.findByUniqueId(data.getData().getUniqueId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return UserTokenResponse.builder()
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
