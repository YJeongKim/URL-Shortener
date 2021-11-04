package dev.yjeong.urlshortener.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandler {

    public void handleBaseException(HttpServletRequest request, HttpServletResponse response,
                                    BaseException exception) throws IOException {
        response.sendError(exception.getHttpStatus().value(), exception.getMessage());
    }

    public void handleRuntimeException(HttpServletRequest request, HttpServletResponse response,
                                       RuntimeException exception) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

}
