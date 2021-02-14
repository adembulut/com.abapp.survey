package com.abapp.survey.front.exception;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:52
*/
public class UserNotAuthenticatedException extends Exception{
    private String message;

    public UserNotAuthenticatedException() {
    }

    public UserNotAuthenticatedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
