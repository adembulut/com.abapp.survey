package com.abapp.survey.backend.rowmapper.auth;

import com.abapp.survey.contract.model.auth.Authority;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 21:20
*/
public class AuthorityMapper implements RowMapper<Authority> {
    private static AuthorityMapper authorityMapper;

    public static AuthorityMapper getInstance() {
        if (authorityMapper == null) {
            authorityMapper = new AuthorityMapper();
        }
        return authorityMapper;
    }

    @Override
    public Authority mapRow(ResultSet resultSet, int i) throws SQLException {
        Authority authority = new Authority();
        authority.setCode(resultSet.getString("authority_code"));
        authority.setDescription(resultSet.getString("authority_description"));
        return authority;
    }
}
