package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class EquipmentOverflowException extends BusinessException {

    public static final EquipmentOverflowException EXCEPTION = new EquipmentOverflowException();

    private EquipmentOverflowException() {
        super(ErrorCode.EQUIPMENT_OVERFLOW);
    }
}
