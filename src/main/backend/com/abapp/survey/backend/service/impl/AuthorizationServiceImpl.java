package com.abapp.survey.backend.service.impl;

import com.abapp.survey.backend.entity.auth.Authority;
import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.model.IUser;
import com.abapp.survey.backend.repository.AuthorizationRepository;
import com.abapp.survey.contract.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:26
*/
public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private AuthorizationRepository authorizationRepository;

    @Override
    public List<Page> getAllPages() {
        return authorizationRepository.getAllPages();
    }

    @Override
    public List<Role> getUserRoles(IUser user) {

        return null;
    }

    @Override
    public List<Authority> getUserAuthorities(IUser user) {

        return null;
    }


    public void setAuthorizationRepository(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }
}
