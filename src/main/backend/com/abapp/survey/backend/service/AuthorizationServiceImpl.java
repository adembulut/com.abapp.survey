package com.abapp.survey.backend.service;

import com.abapp.survey.contract.model.IAdminUser;
import com.abapp.survey.contract.model.auth.Authority;
import com.abapp.survey.contract.model.auth.PageAuthority;
import com.abapp.survey.contract.model.auth.Role;
import com.abapp.survey.contract.service.AuthorizationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:26
*/
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    public Set<PageAuthority> getAllPageAuthorityList() {
        PageAuthority pageAuthority = new PageAuthority();
        pageAuthority.setUrl("/authority-test");
        pageAuthority.setDescription("yetki testi sayfası");

        Authority authority = new Authority();
        authority.setCode("TEST_PAGE");
        pageAuthority.setAuthorityList(Collections.singletonList(authority));
        return Collections.singleton(pageAuthority);
    }

    @Override
    public List<Role> getUserRoles(IAdminUser user) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setCode("ADMIN");
        role.setDescription("Admin Role");
        roles.add(role);
        return roles;
    }

    @Override
    public List<Authority> getUserAuthorities(IAdminUser user) {
        Authority authority = new Authority();
        authority.setCode("TEST_PAGE");
        authority.setDescription("image testi yetkisi");
        return Collections.singletonList(authority);
    }
}
