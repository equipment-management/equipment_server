package com.dgsw.equipment.global.exception;

import com.dgsw.equipment.global.exception.error.ErrorCode;

public class InternalServerErrorException extends BusinessException{

    public static final InternalServerErrorException EXCEPTION = new InternalServerErrorException();

    private InternalServerErrorException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
