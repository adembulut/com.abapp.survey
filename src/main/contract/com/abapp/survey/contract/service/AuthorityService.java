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
    List<Role> getAllRoles();

    List<Authority> getRoleAuthorities(Role role);

    BaseResult addRole(Role role);

    BaseResult updateRoleDescription(Role role);

    BaseResult removeRole(Role role);

    BaseResult addAuthority(Authority authority);

    BaseResult addPageAuthority(Page page, Authority authority);

    BaseResult addPage(Page page);
}
