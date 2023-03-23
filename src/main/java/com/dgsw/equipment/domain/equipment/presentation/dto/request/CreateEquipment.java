package com.dgsw.equipment.domain.equipment.presentation.dto.request;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateEquipment {

    private String name;
    private String brand;
    private EquipmentType type;
    private int size;

    public Equipment toEntity() {
        return Equipment.builder()
                .equipmentName(this.name).brand(this.brand)
                .type(this.type).size(this.size)
                .build();
    }

}
