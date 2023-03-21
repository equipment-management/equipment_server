package com.dgsw.equipment.global.utils;

import com.dgsw.equipment.domain.auth.domain.User;
import com.dgsw.equipment.domain.auth.presentation.dto.response.UserResponse;

public class ResponseUtil {

    public static UserResponse getUserResponse(User user) {
        return UserResponse.builder()
                .grade(user.getGrade()).room(user.getRoom())
                .number(user.getNumber()).name(user.getName())
                .profileImage(user.getProfileImage())
                .role(user.getRole())
                .build();
    }

}
