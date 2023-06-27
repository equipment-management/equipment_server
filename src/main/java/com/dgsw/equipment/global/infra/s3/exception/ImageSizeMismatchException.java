package com.dgsw.equipment.global.infra.s3.exception;

import com.dgsw.equipment.global.exception.BusinessException;
import com.dgsw.equipment.global.exception.error.ErrorCode;

public class ImageSizeMismatchException extends BusinessException {

    public static final ImageSizeMismatchException EXCEPTION = new ImageSizeMismatchException();

    private ImageSizeMismatchException() {
        super(ErrorCode.IMAGE_SIZE_MISMATCH);
    }
}
