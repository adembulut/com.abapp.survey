package com.abapp.survey.front.service.impl;

import com.abapp.survey.contract.model.auth.Authority;
import com.abapp.survey.contract.model.user.AdminUser;
import com.abapp.survey.contract.service.AuthorizationService;
import com.abapp.survey.front.service.UserLoginService;

import java.util.ArrayList;
import java.util.List;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:52
*/
public class UserLoginServiceImpl implements UserLoginService {
    private AuthorizationService authorizationService;
    @Override
    public AdminUser userLogin(String email, String password, int token, String ipAddress, String host, String cookieId) {
        if("adembulutapp@gmail.com".equalsIgnoreCase(email)&&"merdiye".equalsIgnoreCase(password)){
            AdminUser adminUser = new AdminUser();
            adminUser.setUserId(1);
            adminUser.setUsername("adembulut");
            adminUser.setEmail(email);
            adminUser.setNameSurname("Adem Bulut");

            adminUser.setAuthorityList(authorizationService.getUserAuthorities(adminUser));
            return adminUser;
        }
        return null;
    }

    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
}
