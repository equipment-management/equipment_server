package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class UserEquipmentNotFoundException extends BusinessException {

    public static final UserEquipmentNotFoundException EXCEPTION = new UserEquipmentNotFoundException();

    private UserEquipmentNotFoundException() {
        super(ErrorCode.USER_EQUIPMENT_NOT_FOUND);
    }
}
