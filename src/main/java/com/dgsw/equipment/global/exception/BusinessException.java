package com.dgsw.equipment.global.exception;

import com.dgsw.equipment.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

    private final ErrorProperty error;

}
