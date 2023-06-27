package com.dgsw.equipment.global.infra.s3.validation;

import com.dgsw.equipment.global.infra.s3.exception.EmptyFileException;
import com.dgsw.equipment.global.infra.s3.exception.TooLongNameException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@FunctionalInterface
public interface FileValidator {
    void customValidate(MultipartFile file);

    default void validate(MultipartFile file) {
        if (file.isEmpty()) {
            throw EmptyFileException.EXCEPTION;
        }

        if (Objects.nonNull(file.getOriginalFilename()) && file.getOriginalFilename().length() > 20) {
            throw TooLongNameException.EXCEPTION;
        }

        customValidate(file);
    }
}
