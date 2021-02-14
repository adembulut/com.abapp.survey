package com.abapp.survey.front.service;

import com.abapp.survey.contract.model.user.AdminUser;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:53
*/
public interface UserLoginService {
    AdminUser userLogin(String email, String password, int token, String ipAddress, String host, String cookieId);
}
