package com.abapp.survey.contract.service;

import com.abapp.survey.backend.entity.auth.Authority;
import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.model.BaseResult;

import java.util.List;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:48
*/
public interface AuthorityService {
    BaseResult<List<Role>> getAllRoles();

    List<Authority> getRoleAuthorities(Role role);

    BaseResult<Boolean> addRole(Role role);

    BaseResult<Boolean> removeRole(Role role);

    BaseResult<Boolean> addAuthority(Authority authority);

    BaseResult<Boolean> addPageAuthority(Page page, Authority authority);

    BaseResult<Boolean> addPage(Page page);
}
