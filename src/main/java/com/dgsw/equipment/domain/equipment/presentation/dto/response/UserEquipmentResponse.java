package com.dgsw.equipment.domain.equipment.presentation.dto.response;

import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentStatus;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class UserEquipmentResponse {

    private Long userEquipmentId;
    private String equipmentName;
    private String brand;
    private EquipmentType type;
    private int size;
    private EquipmentStatus status;
    private String rentaledAt;
    private String terminateRental;

}
