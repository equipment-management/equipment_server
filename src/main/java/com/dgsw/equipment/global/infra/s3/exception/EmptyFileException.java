package com.dgsw.equipment.global.infra.s3.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class EmptyFileException extends BusinessException {

    public static final EmptyFileException EXCEPTION = new EmptyFileException();

    private EmptyFileException() {
        super(ErrorCode.EMPTY_FILE);
    }
}
