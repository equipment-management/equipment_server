package com.dgsw.equipment.global.infra.s3.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class TooLongNameException extends BusinessException {

    public static final TooLongNameException EXCEPTION = new TooLongNameException();

    private TooLongNameException() {
        super(ErrorCode.TOO_LONG_NAME);
    }
}
