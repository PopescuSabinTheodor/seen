package com.seen.api.error.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
