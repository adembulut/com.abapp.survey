package com.abapp.survey.backend.service;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 21:07
*/
public interface IConnectionPool {
    Connection getConnection();
    void closeConnection(Connection connection);
    void closeConnection(Statement statement,Connection connection);
    void closeConnection(ResultSet resultSet,Statement statement,Connection connection);
    JdbcTemplate getJdbcTemplate();
}
