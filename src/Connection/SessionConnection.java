package Connection;

import java.sql.*;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class SessionConnection {

    private Connection connection;

    public SessionConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = null;
    }

    public boolean createConnection() {
        String url = "jdbc:mysql://localhost:3306/OurFood";
        String username = "root";
        String password = "D4ITA2015";

        boolean isSuccess = true;

        try {
            connection = DriverManager.getConnection(url, username, password); // Membuat koneksi ke database
        } catch (SQLException e) {
            e.printStackTrace();

            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean closeConnection() {
        boolean isSuccess = true;

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

            isSuccess = false;
        }

        return isSuccess;
    }

    public Statement createStatement() {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }
}