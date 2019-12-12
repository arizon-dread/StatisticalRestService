package com.arizon.StatisticalRestService.exception;

import java.util.Date;

public class BadRequestException extends Exception {

    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    public BadRequestException() {
        timestamp = new Date();
        status = 400;
        error = "Bad Request";
        message = "The request was malformed.";
        path = "/";
    }
    public BadRequestException(String message) {
        super(message);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
