package com.abapp.survey.backend.repository;

import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.contract.model.exception.SurveyException;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 16:51
*/
public interface AuthorityRepository {
    void addRole(Role role) throws SurveyException;
    void updateRole(Role role) throws SurveyException;
    Role getRole(String code) throws SurveyException;
    List<Role> listAllRoles() throws SurveyException;
    void removeRole(Role role) throws SurveyException;
}
