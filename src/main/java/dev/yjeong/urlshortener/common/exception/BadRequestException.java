package dev.yjeong.urlshortener.common.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends BaseException {

    public BadRequestException(ExceptionType exceptionType) {
        super(exceptionType);
    }

}
