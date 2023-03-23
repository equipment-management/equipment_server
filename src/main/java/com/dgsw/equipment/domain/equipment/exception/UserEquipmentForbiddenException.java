package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class UserEquipmentForbiddenException extends BusinessException {

    public static final UserEquipmentForbiddenException EXCEPTION = new UserEquipmentForbiddenException();

    private UserEquipmentForbiddenException() {
        super(ErrorCode.USER_EQUIPMENT_FORBIDDEN);
    }
}
