package com.dgsw.equipment.domain.equipment.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentType {

    PHONE("스마트폰"),
    LAPTOP("노트북"),
    DESKTOP("데스크탑"),
    MONITOR("모니터"),
    TABLET("태블릿");

    private final String type;

}
