package com.abapp.survey.backend.model;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:50
*/
public class BaseResult {
    private boolean success;
    private String errorMessage;
    private Throwable exception;

    public BaseResult(boolean success) {
        this.success = success;
    }

    public BaseResult(Throwable exception) {
        this.exception = exception;
    }

    public BaseResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
