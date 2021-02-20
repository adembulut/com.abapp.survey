package com.abapp.survey.backend.service.impl;

import com.abapp.survey.backend.entity.auth.Authority;
import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.repository.AuthorityRepository;
import com.abapp.survey.backend.model.BaseResult;
import com.abapp.survey.contract.service.AuthorityService;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 16:50
*/
public class AuthorityServiceImpl implements AuthorityService {
    private AuthorityRepository authorityRepository;

    @Override
    public List<Role> getAllRoles() {
        return authorityRepository.listAllRoles();
    }

    @Override
    public List<Authority> getRoleAuthorities(Role role) {
        return null;
    }

    @Override
    public BaseResult addRole(Role role) {
        return null;
    }

    @Override
    public BaseResult updateRoleDescription(Role role) {
        return null;
    }

    @Override
    public BaseResult removeRole(Role role) {
        return null;
    }

    @Override
    public BaseResult addAuthority(Authority authority) {
        return null;
    }

    @Override
    public BaseResult addPageAuthority(Page page, Authority authority) {
        return null;
    }

    @Override
    public BaseResult addPage(Page page) {
        return null;
    }

    public void setAuthorityRepository(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
}
