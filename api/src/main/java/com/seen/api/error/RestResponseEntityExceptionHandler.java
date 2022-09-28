package com.seen.api.error;

import com.seen.api.error.exception.ApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { RuntimeException.class })
    protected ResponseEntity<Object> handleRuntime(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Unkown Error Occured";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = { ApiException.class })
    protected ResponseEntity<ErrorDetails> handleApiException(
            ApiException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, ex.getStatus());
    }


}
