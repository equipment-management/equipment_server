package com.dgsw.equipment.domain.equipment.domain;

import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import com.dgsw.equipment.domain.equipment.exception.EquipmentOverflowException;
import com.dgsw.equipment.domain.equipment.exception.EquipmentUnderflowException;
import com.dgsw.equipment.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_equipment")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Equipment extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;
    @Column(unique = true)
    private String equipmentName;
    private String brand;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
    private int size;
    @ColumnDefault("0")
    private int rentalSize;
    public void addRental() {
        if(this.rentalSize <= this.size)
            this.rentalSize++;
        else
            throw EquipmentOverflowException.EXCEPTION;
    }
    public void returnRental() {
        if(this.rentalSize > 0)
            this.rentalSize--;
        else
            throw EquipmentUnderflowException.EXCEPTION;
    }

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEquipment> userList;
    public void addUser(UserEquipment user) {
        user.setEquipment(this);
        getUserList().add(user);
    }

    @Builder
    public Equipment(String equipmentName, String brand, EquipmentType type, int size) {
        this.equipmentName = equipmentName;
        this.brand = brand;
        this.type = type;
        this.size = size;
        this.userList = new ArrayList<>();
    }
}
