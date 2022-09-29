package com.seen.api.error;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String timestamp = LocalDateTime.now().toString();
    private String message;
    private String details;

    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}