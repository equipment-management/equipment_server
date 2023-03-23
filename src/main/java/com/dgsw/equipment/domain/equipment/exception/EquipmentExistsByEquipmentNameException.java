package com.dgsw.equipment.domain.equipment.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class EquipmentExistsByEquipmentNameException extends BusinessException {

    public static final EquipmentExistsByEquipmentNameException EXCEPTION = new EquipmentExistsByEquipmentNameException();

    private EquipmentExistsByEquipmentNameException() {
        super(ErrorCode.EQUIPMENT_CONFLICT);
    }
}
