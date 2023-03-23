package com.dgsw.equipment.domain.user.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class AdminForbiddenException extends BusinessException {

    public static final AdminForbiddenException EXCEPTION = new AdminForbiddenException();

    private AdminForbiddenException() {
        super(ErrorCode.ADMIN_FORBIDDEN);
    }
}
