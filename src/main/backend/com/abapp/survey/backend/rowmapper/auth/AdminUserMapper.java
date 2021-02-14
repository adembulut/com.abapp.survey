package com.abapp.survey.backend.rowmapper.auth;

import com.abapp.survey.contract.model.user.AdminUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:01
*/
public class AdminUserMapper implements RowMapper<AdminUser> {
    private static AdminUserMapper adminUserMapper;

    public static AdminUserMapper getInstance() {
        if (adminUserMapper == null) {
            adminUserMapper = new AdminUserMapper();
        }
        return adminUserMapper;
    }

    @Override
    public AdminUser mapRow(ResultSet resultSet, int i) throws SQLException {
        AdminUser adminUser = new AdminUser();
        adminUser.setUserId(resultSet.getLong("userid"));
        adminUser.setEmail(resultSet.getString("email"));
        adminUser.setNameSurname(resultSet.getString("namesurname"));
        adminUser.setUsername(resultSet.getString("username"));
        return adminUser;
    }
}
