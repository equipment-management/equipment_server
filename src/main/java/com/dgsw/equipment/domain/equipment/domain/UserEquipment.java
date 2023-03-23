package com.dgsw.equipment.domain.equipment.domain;

import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentStatus;
import com.dgsw.equipment.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_user_equipment")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "fk_equipment_id")
    private Equipment equipment;
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate rentaledAt;

    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate terminateRental;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;
    public void returnEquipment() {
        this.status = EquipmentStatus.RETURN;
    }

    @PrePersist
    public void prePersist() {
        this.status = this.status == null ? EquipmentStatus.PENDING : this.status;
    }

    @Builder
    public UserEquipment(User user, Equipment equipment, LocalDate rentaledAt, LocalDate terminateRental) {
        this.user = user;
        this.equipment = equipment;
        this.rentaledAt = rentaledAt;
        this.terminateRental = terminateRental;
    }
}
