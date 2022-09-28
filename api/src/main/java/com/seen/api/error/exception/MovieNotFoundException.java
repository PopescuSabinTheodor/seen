package com.seen.api.error.exception;

import com.seen.api.error.ApiErrorMessage;
import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends ApiException {

    public MovieNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public MovieNotFoundException() {
        this(ApiErrorMessage.MOVIE_NOT_FOUND.getMessage());
    }

}
