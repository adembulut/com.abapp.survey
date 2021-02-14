package com.abapp.survey.backend.rowmapper.auth;

import com.abapp.survey.contract.model.auth.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 21:53
*/
public class RoleMapper implements RowMapper<Role> {
    private static RoleMapper roleMapper;

    public static RoleMapper getInstance() {
        if (roleMapper == null) {
            roleMapper = new RoleMapper();
        }
        return roleMapper;
    }

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();
        role.setCode(resultSet.getString("role_code"));
        role.setDescription(resultSet.getString("role_description"));
        return role;
    }
}
