package dev.yjeong.urlshortener.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionType {

    INVALID_URL_FORMAT(HttpStatus.BAD_REQUEST, "유효하지 않는 URL 입니다."),
    NOT_FOUNT_URL(HttpStatus.NOT_FOUND, "존재하지 않는 URL 입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
