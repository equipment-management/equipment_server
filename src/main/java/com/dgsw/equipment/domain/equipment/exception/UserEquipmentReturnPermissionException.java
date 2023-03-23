package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class UserEquipmentReturnPermissionException extends BusinessException {

    public static final UserEquipmentReturnPermissionException EXCEPTION = new UserEquipmentReturnPermissionException();

    private UserEquipmentReturnPermissionException() {
        super(ErrorCode.USER_EQUIPMENT_RETURN_PERMISSION);
    }
}
