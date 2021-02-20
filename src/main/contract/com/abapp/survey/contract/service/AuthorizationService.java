package com.abapp.survey.contract.service;

import com.abapp.survey.backend.entity.auth.Authority;
import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.model.IAdminUser;


import java.util.List;

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
