package com.abapp.survey.backend.service.impl.base;

import com.abapp.survey.backend.service.IConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 21:08
*/
public class ConnectionPool implements IConnectionPool, InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.dataSource = jdbcTemplate.getDataSource();
    }


    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            LOGGER.error("an error occurred while getConnection", e);
        }
        return null;
    }

    @Override
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void closeConnection(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception ignored) {
            }
        }
        closeConnection(connection);
    }

    @Override
    public void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception ignored) {
            }
        }
        closeConnection(statement, connection);
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
