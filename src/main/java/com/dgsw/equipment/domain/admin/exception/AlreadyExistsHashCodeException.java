package com.dgsw.equipment.domain.admin.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class AlreadyExistsHashCodeException extends BusinessException {

    public static final AlreadyExistsHashCodeException EXCEPTION = new AlreadyExistsHashCodeException();

    private AlreadyExistsHashCodeException() {
        super(ErrorCode.ALREADY_HASHCODE);
    }
}
