package com.abapp.survey.contract.service;

import com.abapp.survey.contract.model.IAdminUser;
import com.abapp.survey.contract.model.auth.Authority;
import com.abapp.survey.contract.model.auth.Page;
import com.abapp.survey.contract.model.auth.Role;

import java.util.List;
import java.util.Set;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:24
*/
public interface AuthorizationService {
    List<Page> getAllPages();

    List<Role> getUserRoles(IAdminUser user);

    List<Authority> getUserAuthorities(IAdminUser user);
}
