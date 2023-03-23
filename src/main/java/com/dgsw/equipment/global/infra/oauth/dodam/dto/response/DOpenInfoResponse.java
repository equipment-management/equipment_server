package com.dgsw.equipment.global.infra.oauth.dodam.dto.response;

import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.domain.enums.UserRole;
import lombok.*;

import java.io.Serializable;

@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DOpenInfoResponse implements Serializable {

    private String uniqueId;
    private int grade;
    private int room;
    private int number;
    private String name;
    private String email;
    private String profileImage;
    private int accessLevel;

    public User toEntity() {
        return User.builder()
                .uniqueId(this.uniqueId).profileImage(this.profileImage)
                .grade(this.grade).room(this.room).number(this.number).name(this.name)
                .role(accessLevel == 0 ? UserRole.ROLE_STUDENT : accessLevel == 1 ? UserRole.ROLE_TEACHER : UserRole.ROLE_ADMIN)
                .build();
    }

}
