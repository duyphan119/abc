package com.api.shoesshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectDB {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USERNAME = "c##OT";
    private static final String DB_PASSWORD = "123456";

    @Autowired
    Environment env;

    public static Connection connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
