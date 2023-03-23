package com.dgsw.equipment.domain.equipment.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentStatus {

    APPROVE("승인"),
    DENY("거절"),
    PENDING("보류"),
    RETURN("반납");

    private final String status;

}
