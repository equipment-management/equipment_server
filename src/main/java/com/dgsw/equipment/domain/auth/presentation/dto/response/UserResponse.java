package com.dgsw.equipment.domain.auth.presentation.dto.response;

import com.dgsw.equipment.domain.auth.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class UserResponse {

    private int grade;
    private int room;
    private int number;
    private String name;
    private String profileImage;
    private UserRole role;

}
