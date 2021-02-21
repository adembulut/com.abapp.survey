package com.abapp.survey.contract.model.exception;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 21/02/2021 14:06
*/
public class TechnicalException extends SurveyException{
    private String messageCode = "survey.error.general.remove";

    public TechnicalException( String messageCode, Throwable cause) {
        super(messageCode, cause);
        this.messageCode = messageCode;
    }

    public TechnicalException(Throwable cause) {
        super("survey.error.general.remove",cause);
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
