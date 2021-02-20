//package com.abapp.survey.backend.service.impl;
//
//import com.abapp.survey.backend.rowmapper.auth.AuthorityMapper;
//import com.abapp.survey.backend.rowmapper.auth.RoleMapper;
//import com.abapp.survey.backend.service.IConnectionPool;
//import com.abapp.survey.backend.model.BaseResult;
//import com.abapp.survey.contract.model.auth.Authority;
//import com.abapp.survey.contract.model.auth.Page;
//import com.abapp.survey.contract.model.auth.Role;
//import com.abapp.survey.contract.service.AuthorityService;
//
//import java.util.List;
//
///*
//    Project : com.abapp.survey
//    User    : adem.bulut
//    Date    : 2/14/21 22:54
//*/
//public class AuthorityServiceImplOld implements AuthorityService {
//    private IConnectionPool connectionPool;
//
//    @Override
//    public List<Role> getAllRoles() {
//        return connectionPool.getJdbcTemplate().query("select r.* from role r where 1=1", RoleMapper.getInstance());
//    }
//
//    @Override
//    public List<Authority> getRoleAuthorities(Role role) {
//        if (role == null || role.getCode() == null) {
//            return null;
//        }
//        String sql = "select a.* from authority a " +
//                "inner join role_authority ra on a.authority_code = ra.authority_code " +
//                "where ra.role_code=? ";
//        return connectionPool.getJdbcTemplate().query(sql, new Object[]{role.getCode()}, AuthorityMapper.getInstance());
//    }
//
//    @Override
//    public BaseResult addRole(Role role) {
//        return null;
//    }
//
//    @Override
//    public BaseResult updateRoleDescription(Role role) {
//        return null;
//    }
//
//    @Override
//    public BaseResult removeRole(Role role) {
//        return null;
//    }
//
//    @Override
//    public BaseResult addAuthority(Authority authority) {
//        return null;
//    }
//
//    @Override
//    public BaseResult addPageAuthority(Page page, Authority authority) {
//        return null;
//    }
//
//    @Override
//    public BaseResult addPage(Page page) {
//        return null;
//    }
//
//    public void setConnectionPool(IConnectionPool connectionPool) {
//        this.connectionPool = connectionPool;
//    }
//}
