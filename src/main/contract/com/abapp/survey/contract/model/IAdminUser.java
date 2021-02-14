package com.abapp.survey.contract.model;

import com.abapp.survey.contract.model.auth.Authority;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:39
*/
public interface IAdminUser extends Serializable {
    long getUserId();
    String getUsername();
    String getNameSurname();
    Locale getLocale();
    String getEmail();
    List<Authority> getAuthorityList();
}
