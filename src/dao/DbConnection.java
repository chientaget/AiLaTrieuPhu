package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_altp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        String connectionUrl
                = "jdbc:sqlserver://CHIENAK\\SQLEXPRESS:1433;"
                + "database=db_altp;"
                + "user=sa;"
                + "password=Chiencold.23;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

       return DriverManager.getConnection(connectionUrl);
    }
}
