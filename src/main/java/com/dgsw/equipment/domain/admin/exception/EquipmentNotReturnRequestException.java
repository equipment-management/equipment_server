package com.dgsw.equipment.domain.admin.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class EquipmentNotReturnRequestException extends BusinessException {

    public static final EquipmentNotReturnRequestException EXCEPTION = new EquipmentNotReturnRequestException();
    private EquipmentNotReturnRequestException() {
        super(ErrorCode.USER_EQUIPMENT_RETURN_REQUEST);
    }
}
