package com.dgsw.equipment.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorProperty{

    // 기본 코드
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 오류가 발생하였습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "리소스를 찾을 수 없습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "권한이 없습니다."),

    // Jwt 코드
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),

    // Auth 코드
    USER_CONFLICT(HttpStatus.CONFLICT, "유저가 이미 존재합니다."),
    PASSWORD_WRONG(HttpStatus.BAD_REQUEST, "비밀번호가 맞지 않습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    ADMIN_FORBIDDEN(HttpStatus.FORBIDDEN, "관리자 권한이 존재하지 않습니다."),

    // DAuth 코드
    DAUTH_FALSIFY_CODE(HttpStatus.BAD_REQUEST, "변조된 CODE 입니다."),
    DAUTH_TOKEN_CODE(HttpStatus.BAD_REQUEST, "토큰이 잘못된었습니다."),

    // Equipment 코드
    EQUIPMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "기자재를 찾을 수 없습니다."),
    EQUIPMENT_CONFLICT(HttpStatus.CONFLICT, "기자재가 이미 존재합니다."),
    EQUIPMENT_OVERFLOW(HttpStatus.BAD_REQUEST, "기자재 개수를 초과하였습니다."),
    EQUIPMENT_UNDERFLOW(HttpStatus.BAD_REQUEST, "반납할 기자재가 존재하지 않습니다."),
    HASHCODE_WRONG(HttpStatus.BAD_REQUEST, "기자재의 해시코드가 맞지 않습니다."),
    ALREADY_HASHCODE(HttpStatus.CONFLICT, "이미 존재하는 해시코드입니다."),

    // User Equipment 코드
    USER_EQUIPMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "신청한 기자재를 찾을 수 없습니다."),
    USER_EQUIPMENT_FORBIDDEN(HttpStatus.FORBIDDEN, "기자재에 대한 권한이 없습니다."),
    USER_EQUIPMENT_RETURN_PERMISSION(HttpStatus.FORBIDDEN, "기자재를 반납할 권한이 없습니다."),
    USER_EQUIPMENT_RETURN_REQUEST(HttpStatus.FORBIDDEN, "기자재 반납신청이 되지 않은 기자재입니다."),

    // Image 코드
    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "이미지를 찾을 수 없습니다."),

    // File 코드
    EMPTY_FILE(HttpStatus.BAD_REQUEST, "파일이 비어있습니다."),
    TOO_LONG_NAME(HttpStatus.BAD_REQUEST, "파일 이름이 너무 깁니다."),
    FAILED_TO_SAVE(HttpStatus.FAILED_DEPENDENCY, "저장에 실패했습니다."),
    IMAGE_SIZE_MISMATCH(HttpStatus.NOT_FOUND, "이미지 사이즈가 너무 크거나 작습니다."),
    OVER_FILE_SIZE_LIMIT(HttpStatus.PAYLOAD_TOO_LARGE, "파일 사이즈는 1MB 이하여야 합니다."),
    INVALID_FORMAT(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일입니다.")
    ;

    private final HttpStatus status;
    private final String message;

}