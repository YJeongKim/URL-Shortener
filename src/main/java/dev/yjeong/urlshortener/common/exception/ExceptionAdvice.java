package dev.yjeong.urlshortener.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ExceptionResponse> handleBaseException(BaseException exception) {
        log.error("BaseException - " + exception);
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(ExceptionResponse.builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(HttpServletRequest request, HttpServletResponse response,
                                       RuntimeException exception) throws IOException {
        log.error("RunTimeException - " + exception);
        exception.printStackTrace();
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

}
