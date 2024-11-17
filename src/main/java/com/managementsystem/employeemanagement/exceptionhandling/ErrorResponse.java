package com.managementsystem.employeemanagement.exceptionhandling;

public class ErrorResponse {
    private String errorCode;
    private long timestamp;
    private int statusCode;

    public ErrorResponse(String errorCode, int statusCode) {
        this.errorCode = errorCode;
        this.statusCode = statusCode;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
