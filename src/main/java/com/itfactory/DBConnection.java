package com.itfactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public static Connection createDBConnetion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcUrl = "jdbc:mysql://localhost:3306/users?allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "admin";
            con = DriverManager.getConnection(jdbcUrl, username, password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;

    }
}
