package com.abapp.survey.contract.model.exception;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 21/02/2021 14:07
*/
public class SurveyException extends Exception {
    private String messageCode;

    public SurveyException(String messageCode) {
        this.messageCode = messageCode;
    }

    public SurveyException(String messageCode, Throwable cause) {
        super(messageCode, cause);
        this.messageCode = messageCode;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
