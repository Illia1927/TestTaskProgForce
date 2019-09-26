package com.progForce.testTask.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
    private static final Logger logger = Logger.getLogger(JdbcConnector.class);
    private static final String URL = "jdbc:mysql://localhost:3306/progforce?serverTimezone=UTC";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "test";
    private static final String PASS = "test";
    private static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
            logger.debug("Connection is ok");
        } catch (ClassNotFoundException e) {
            logger.debug("JDBC Driver was not loaded: ");
            logger.error(e);
            System.exit(1);
        } catch (SQLException e) {
            logger.debug("Connection to DB was not established: ");
            logger.error(e);
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
