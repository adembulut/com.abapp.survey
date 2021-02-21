package com.abapp.survey.contract.model.exception;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 21/02/2021 14:09
*/
public class UserMessageException extends SurveyException{
    public UserMessageException(String messageCode) {
        super(messageCode);
    }

    public UserMessageException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }
}
