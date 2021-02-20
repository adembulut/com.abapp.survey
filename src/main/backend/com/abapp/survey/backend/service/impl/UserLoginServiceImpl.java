package com.abapp.survey.backend.service.impl;

import com.abapp.survey.backend.entity.user.User;
import com.abapp.survey.backend.service.IConnectionPool;
import com.abapp.survey.backend.utils.PasswordUtil;
import com.abapp.survey.contract.service.AuthorizationService;
import com.abapp.survey.front.service.UserLoginService;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:52
*/
public class UserLoginServiceImpl implements UserLoginService {
    private AuthorizationService authorizationService;
    private IConnectionPool connectionPool;

    @Override
    public User userLogin(String email, String password, int token, String ipAddress, String host, String cookieId) {
        if (email == null || password == null) {
            return null;
        }
        password = PasswordUtil.encodePassword(password);
//        User adminUser = connectionPool.getJdbcTemplate().queryForObject("select au.* from admin_user au where au.email=? and au.password=?", new Object[]{email, password}, AdminUserMapper.getInstance());
//        if(adminUser!=null){
//            adminUser.(authorizationService.getUserAuthorities(adminUser));
//        }
        return null;
    }

    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void setConnectionPool(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
