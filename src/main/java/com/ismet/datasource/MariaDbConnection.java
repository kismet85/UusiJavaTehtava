package com.ismet.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

        private static final String DB_URL = "jdbc:mariadb://localhost:3306/currencyconverterdb";
        private static final String DB_USER = "root"; //
        private static final String DB_PASSWORD = "password";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        public static void terminate() {
            try {
                getConnection().close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
}
