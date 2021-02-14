package com.abapp.survey.backend.service.impl;

import com.abapp.survey.backend.rowmapper.auth.AuthorityMapper;
import com.abapp.survey.backend.rowmapper.auth.PageMapper;
import com.abapp.survey.backend.rowmapper.auth.RoleMapper;
import com.abapp.survey.backend.service.impl.base.ConnectionPool;
import com.abapp.survey.contract.model.IAdminUser;
import com.abapp.survey.contract.model.auth.Authority;
import com.abapp.survey.contract.model.auth.Page;
import com.abapp.survey.contract.model.auth.Role;
import com.abapp.survey.contract.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:26
*/
public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ConnectionPool connectionPool;

    @Override
    public List<Page> getAllPages() {

        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from page");
            ResultSet resultSet = statement.executeQuery();
            List<Page> pageList = new ArrayList<>();
            PreparedStatement authStatement = connection.prepareStatement("select a.* from authority a " +
                    "inner join page_authority pa on a.authority_code = pa.authority_code " +
                    "inner join page p on pa.page_url = p.page_url " +
                    "where p.page_url=?");
            while (resultSet.next()) {
                Page page = PageMapper.getInstance().mapRow(resultSet, 1);
                if (page == null) {
                    continue;
                }
                authStatement.setString(1, page.getUrl());
                ResultSet resultSetAuth = authStatement.executeQuery();
                List<Authority> authorityList = new ArrayList<>();
                while (resultSetAuth.next()) {
                    authorityList.add(AuthorityMapper.getInstance().mapRow(resultSet, 1));
                }
                resultSetAuth.close();
                page.setAuthorityList(authorityList);
                pageList.add(page);
            }
            resultSet.close();
            authStatement.close();
            statement.close();
            return pageList;
        } catch (Exception e) {
            logger.error("an error occurred while getAllPages", e);
            return null;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public List<Role> getUserRoles(IAdminUser user) {
        return connectionPool.getJdbcTemplate().query("select a.* from user_role a where a.username=?", RoleMapper.getInstance());
    }

    @Override
    public List<Authority> getUserAuthorities(IAdminUser user) {
        return connectionPool.getJdbcTemplate().query("select a.* from authority a\n" +
                "inner join role_authority ra on a.authority_code = ra.authority_code\n" +
                "inner join role r on r.role_code = ra.role_code\n" +
                "inner join user_role ur on r.role_code = ur.role_code\n" +
                "where ur.username=?", new Object[]{user.getUsername()}, AuthorityMapper.getInstance());
    }

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
