package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/db_school";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

        public static Connection getConnection() {
        try{
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }
}
