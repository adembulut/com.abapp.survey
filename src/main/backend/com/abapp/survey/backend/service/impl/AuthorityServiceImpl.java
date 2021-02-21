package com.abapp.survey.backend.service.impl;

import com.abapp.survey.backend.entity.auth.Authority;
import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.model.BaseResult;
import com.abapp.survey.backend.repository.AuthorityRepository;
import com.abapp.survey.contract.model.exception.SurveyException;
import com.abapp.survey.contract.service.AuthorityService;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 16:50
*/
public class AuthorityServiceImpl implements AuthorityService {
    private AuthorityRepository authorityRepository;
    private static final String TECH_ERROR="survey.general.error.technical";

    @Override
    public BaseResult<List<Role>> getAllRoles() {
        BaseResult<List<Role>> result = new BaseResult<>();
        try {
            result.setData(authorityRepository.listAllRoles());
        }catch (SurveyException e){
            result.setErrorMessage(e.getMessageCode());
        }catch (Exception e){
            result.setErrorMessage(TECH_ERROR);
        }
        return result;
    }

    @Override
    public List<Authority> getRoleAuthorities(Role role) {
        return null;
    }

    @Override
    public BaseResult<Boolean> addRole(Role role) {
        BaseResult<Boolean> baseResult = new BaseResult<>();
        try {
            authorityRepository.addRole(role);
            baseResult.setData(true);
        } catch (SurveyException e) {
            baseResult.setErrorMessage(e.getMessageCode());
        }catch (Exception e){
            baseResult.setErrorMessage(TECH_ERROR);
        }
        return baseResult;
    }

    @Override
    public BaseResult<Boolean> removeRole(Role role) {
        BaseResult<Boolean> result = new BaseResult<>();
        try{
            authorityRepository.removeRole(role);
            result.setData(true);
        }catch (SurveyException e){
            result.setErrorMessage(e.getMessageCode());
        }catch (Exception e){
            result.setErrorMessage(TECH_ERROR);
        }
        return result;
    }

    @Override
    public BaseResult<Boolean> addAuthority(Authority authority) {
        return null;
    }

    @Override
    public BaseResult<Boolean> addPageAuthority(Page page, Authority authority) {
        return null;
    }

    @Override
    public BaseResult<Boolean> addPage(Page page) {
        return null;
    }

    public void setAuthorityRepository(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
}
