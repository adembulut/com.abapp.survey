package com.abapp.survey.backend.model;


import java.io.Serializable;
import java.util.Locale;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:39
*/
public interface IUser extends Serializable {
    String getUsername();

    String getNameSurname();

    Locale getLocale();

    String getEmail();
}
