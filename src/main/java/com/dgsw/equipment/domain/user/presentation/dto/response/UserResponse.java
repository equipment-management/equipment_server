package com.dgsw.equipment.domain.user.presentation.dto.response;

import com.dgsw.equipment.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class UserResponse {

    private String name;
    private String profileImage;
    private UserRole role;

}
