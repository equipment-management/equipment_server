package com.dgsw.equipment.domain.admin.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class HashCodeWrongException extends BusinessException {

    public static final HashCodeWrongException EXCEPTION = new HashCodeWrongException();

    private HashCodeWrongException() {
        super(ErrorCode.HASHCODE_WRONG);
    }
}
