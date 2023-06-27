package com.dgsw.equipment.global.infra.s3.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class FailedToSaveException extends BusinessException {

    public static final FailedToSaveException EXCEPTION = new FailedToSaveException();

    private FailedToSaveException() {
        super(ErrorCode.FAILED_TO_SAVE);
    }
}
