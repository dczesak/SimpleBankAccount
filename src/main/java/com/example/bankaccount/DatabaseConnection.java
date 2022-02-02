package com.example.bankaccount;
import java.sql.*;

public class DatabaseConnection {
    public static Connection connectToDatabase() {
        String jdbcURL="jdbc:postgresql://localhost:5432/bancaccount";
        String username = "postgres";
        String password = "B@zy5432!";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to server");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error in connection to database");
            e.printStackTrace();
            return null;
        }
    }
}
