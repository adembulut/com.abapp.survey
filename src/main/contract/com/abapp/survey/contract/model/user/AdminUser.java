package com.abapp.survey.contract.model.user;

import com.abapp.survey.contract.model.IAdminUser;
import com.abapp.survey.contract.model.auth.Authority;

import java.util.List;
import java.util.Locale;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:40
*/
public class AdminUser implements IAdminUser {
    private long userId;
    private String username;
    private String nameSurname;
    private Locale locale;
    private String email;
    private List<Authority> authorityList;


    @Override
    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
