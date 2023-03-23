package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class EquipmentNotFoundException extends BusinessException {

    public static final EquipmentNotFoundException EXCEPTION = new EquipmentNotFoundException();

    private EquipmentNotFoundException() {
        super(ErrorCode.EQUIPMENT_NOT_FOUND);
    }
}
