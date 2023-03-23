package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class EquipmentUnderflowException extends BusinessException {

    public static final EquipmentUnderflowException EXCEPTION = new EquipmentUnderflowException();

    private EquipmentUnderflowException() {
        super(ErrorCode.EQUIPMENT_UNDERFLOW);
    }
}
