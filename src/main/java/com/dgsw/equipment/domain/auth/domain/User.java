package com.dgsw.equipment.domain.auth.domain;

import com.dgsw.equipment.domain.auth.domain.enums.UserRole;
import com.dgsw.equipment.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uniqueId;

    private int grade;
    private int room;
    private int number;
    private String name;
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public void updateUser(int grade, int room, int number, String name, String profileImage) {
        this.grade = this.grade == grade ? this.grade : grade;
        this.room = this.room == room ? this.room : room;
        this.number = this.number == number ? this.number : number;
        this.name = this.name.equals(name) ? this.name : name;
        this.profileImage = this.profileImage.equals(profileImage) ?  this.profileImage: profileImage;
    }

    @Builder
    public User(String uniqueId, int grade, int room, int number, String name, String profileImage, UserRole role) {
        this.uniqueId = uniqueId;
        this.grade = grade;
        this.room = room;
        this.number = number;
        this.name = name;
        this.profileImage = profileImage;
        this.role = role;
    }
}
