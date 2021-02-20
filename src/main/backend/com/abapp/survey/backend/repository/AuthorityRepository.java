package com.abapp.survey.backend.repository;

import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 16:51
*/
public interface AuthorityRepository {
    void saveOrUpdateRole(Role role);
    Role getRole(String code);
    List<Role> listAllRoles();
}
