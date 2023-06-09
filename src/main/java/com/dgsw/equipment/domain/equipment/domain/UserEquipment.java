package com.dgsw.equipment.domain.equipment.domain;

import com.dgsw.equipment.domain.admin.exception.HashCodeWrongException;
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

    private String reason;
    @Column(unique = true)
    private String hashCode;
    public void addHashCode(String hashCode) {
        this.hashCode = hashCode;
    }
    public void checkHashCode(String hashCode) {
        if(!this.hashCode.equals(hashCode))
            throw HashCodeWrongException.EXCEPTION;
    }

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;
    public void returnEquipment() {
        this.status = EquipmentStatus.RETURN;
    }
    public void denyEquipment() {
        this.status = EquipmentStatus.DENY;
    }
    public void returnRequestRquipment() {
        this.status = EquipmentStatus.RETURN_REQUEST;
    }
    public void approveEquipment() {
        this.status = EquipmentStatus.APPROVE;
    }

    @PrePersist
    public void prePersist() {
        this.status = this.status == null ? EquipmentStatus.PENDING : this.status;
    }

    @Builder
    public UserEquipment(User user, Equipment equipment, LocalDate rentaledAt, LocalDate terminateRental, String reason) {
        this.user = user;
        this.equipment = equipment;
        this.rentaledAt = rentaledAt;
        this.terminateRental = terminateRental;
        this.reason = reason;
    }
}
