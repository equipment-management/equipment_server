package com.dgsw.equipment.domain.equipment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
@AllArgsConstructor
public class EquipmentListResponse {

    private List<EquipmentResponse> list;

}
