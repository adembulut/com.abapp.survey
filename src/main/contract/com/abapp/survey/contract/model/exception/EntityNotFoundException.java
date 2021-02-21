package com.abapp.survey.contract.model.exception;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 21/02/2021 14:04
*/
public class EntityNotFoundException extends Exception{
    private String messageCode;

    public String getMessageCode() {
        return messageCode;
    }

    public EntityNotFoundException(String messageCode) {
        this.messageCode = messageCode;
    }

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String messageCode, Throwable cause) {
        super(messageCode,cause);
        this.messageCode = messageCode;
    }
}
