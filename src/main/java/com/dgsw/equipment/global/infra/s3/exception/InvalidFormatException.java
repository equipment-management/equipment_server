package com.dgsw.equipment.global.infra.s3.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class InvalidFormatException extends BusinessException {

    public static final InvalidFormatException EXCEPTION = new InvalidFormatException();

    private InvalidFormatException() {
        super(ErrorCode.INVALID_FORMAT);
    }
}
