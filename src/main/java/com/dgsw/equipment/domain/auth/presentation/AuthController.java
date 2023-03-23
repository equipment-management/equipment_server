package com.dgsw.equipment.domain.auth.presentation;

import com.dgsw.equipment.domain.auth.presentation.dto.request.LoginRequest;
import com.dgsw.equipment.domain.auth.presentation.dto.response.TokenResponse;
import com.dgsw.equipment.domain.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "인증 서버")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "DAuth로 로그인")
    @PostMapping("/dauth/login")
    public TokenResponse dauthLogin(
            @RequestBody LoginRequest request
    ) {
        return authService.login(request);
    }

}
