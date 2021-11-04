package dev.yjeong.urlshortener.common.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

    public NotFoundException(ExceptionType exceptionType) {
        super(exceptionType);
    }

}
