package com.abapp.survey.backend.rowmapper.auth;

import com.abapp.survey.contract.model.auth.Page;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 21:30
*/
public class PageMapper implements RowMapper<Page> {
    private static PageMapper pageMapper;

    public static PageMapper getInstance() {
        if (pageMapper == null) {
            pageMapper = new PageMapper();
        }
        return pageMapper;
    }

    @Override
    public Page mapRow(ResultSet resultSet, int i) throws SQLException {
        Page page = new Page();
        page.setUrl(resultSet.getString("page_url"));
        page.setDescription(resultSet.getString("page_description"));
        return page;
    }
}
