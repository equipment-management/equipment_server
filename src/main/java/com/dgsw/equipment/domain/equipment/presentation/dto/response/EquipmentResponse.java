package com.dgsw.equipment.domain.equipment.presentation.dto.response;

import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class EquipmentResponse {

    private Long equipmentId;
    private String equipmentName;
    private String brand;
    private EquipmentType type;
    private int size;

}
