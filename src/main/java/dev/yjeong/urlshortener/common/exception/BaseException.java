package dev.yjeong.urlshortener.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public BaseException(ExceptionType exceptionType) {
        this.httpStatus = exceptionType.getHttpStatus();
        this.message = exceptionType.getMessage();
    }

}
