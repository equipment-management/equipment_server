package com.dgsw.equipment.domain.equipment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class EquipmentTypeResponse {

    private final String[] typeList;

}
