package com.dgsw.equipment.global.infra.oauth.dodam.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class DAuthFalsifyCodeException extends BusinessException {

    public static final DAuthFalsifyCodeException EXCEPTION = new DAuthFalsifyCodeException();

    private DAuthFalsifyCodeException() {
        super(ErrorCode.DAUTH_FALSIFY_CODE);
    }
}
