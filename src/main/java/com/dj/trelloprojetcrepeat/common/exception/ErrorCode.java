package com.dj.trelloprojetcrepeat.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // Auth
    USER_EXISTING(HttpStatus.CONFLICT, "이미 가입된 유저입니다."),
    //

    //

    // 기본 코드
    NOT_FOUND(HttpStatus.NOT_FOUND, "찾지못했습니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message){
        this.status = httpStatus;
        this.message = message;
    }

    public String customMessage(String detail) {
        return String.format(message, detail);
    }
}
