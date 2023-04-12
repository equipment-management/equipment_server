package com.dgsw.equipment.domain.upload.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class ImageNotFoundException extends BusinessException {

    public static final ImageNotFoundException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }
}
