package com.dgsw.equipment.domain.auth.presentation;

import com.dgsw.equipment.domain.auth.presentation.dto.request.UserLoginRequest;
import com.dgsw.equipment.domain.auth.presentation.dto.response.UserTokenResponse;
import com.dgsw.equipment.domain.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/dauth/login")
    public UserTokenResponse dauthLogin(
            @RequestBody UserLoginRequest request
    ) {
        return userService.login(request);
    }

}
