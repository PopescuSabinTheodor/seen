package com.seen.api.error;

import org.springframework.http.HttpStatus;

public enum ApiErrorMessage {

    MOVIE_NOT_FOUND("The movie could not be found.");

    private final String message;

    ApiErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
