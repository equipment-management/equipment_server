package com.dgsw.equipment.domain.user.presentation;

import com.dgsw.equipment.domain.user.presentation.dto.response.UserResponse;
import com.dgsw.equipment.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "유저 서버")
public class UserController {

    private final UserService userService;

    @Operation(summary = "현재 로그인한 유저의 프로필 정보 조회")
    @GetMapping("/{unique-id}")
    public UserResponse getUserInfo(
            @PathVariable("unique-id") String uniqueId
    ) {
        return userService.getUserInfo(uniqueId);
    }

}
