package com.dgsw.equipment.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class ErrorResponse {

    private final int status;
    private final String message;

}
