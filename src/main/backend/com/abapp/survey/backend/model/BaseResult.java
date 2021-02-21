package com.abapp.survey.backend.model;

import java.io.Serializable;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:50
*/
public class BaseResult<T> implements Serializable {
    private boolean success;
    private String errorMessage;
    private Object[] args;
    private T data;


    public BaseResult() {
    }

    public BaseResult(T data) {
        this.data = data;
    }

    public BaseResult(boolean success) {
        this.success = success;
    }


    public BaseResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }


    public BaseResult(String errorMessage, String[] args) {
        this.errorMessage = errorMessage;
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        this.success=true;
    }

    public boolean isSuccess() {
        return success;
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
