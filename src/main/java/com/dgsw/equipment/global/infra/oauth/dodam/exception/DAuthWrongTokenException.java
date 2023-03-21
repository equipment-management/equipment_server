package com.dgsw.equipment.global.infra.oauth.dodam.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class DAuthWrongTokenException extends BusinessException {

    public static final DAuthWrongTokenException EXCEPTION = new DAuthWrongTokenException();

    private DAuthWrongTokenException() {
        super(ErrorCode.DAUTH_TOKEN_CODE);
    }
}
