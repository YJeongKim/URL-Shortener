package dev.yjeong.urlshortener.common.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponse {

    private String message;

    @Builder
    public ExceptionResponse(String message) {
        this.message = message;
    }

}
