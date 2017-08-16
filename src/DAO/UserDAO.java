package DAO;

import Connection.SessionConnection;
import Model.UserModel;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class UserDAO {
    private SessionConnection connection;

    public UserDAO() {
        connection = new SessionConnection();
        connection.createConnection();
    }

    public int insertUser(UserModel userModel) {
        Statement statement = connection.createStatement();
        int hasil = -1;

        String password = Base64.getEncoder().encodeToString(userModel.getPassword().getBytes());

        if (statement != null) {
            userModel.setPassword(password);
            String sql = "INSERT INTO user(username, password, last_login) VALUES('" + userModel.getUsername() + "', '" + userModel.getPassword() + "', '" + userModel.getLastLogin() + "')";

            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hasil;
    }

    public ArrayList<UserModel> showUser() {
        ArrayList<UserModel> dataList = null;
        Statement statement = connection.createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM user ORDER BY last_login DESC";
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (resultSet != null) {
                dataList = new ArrayList<>();

                try {
                    while (resultSet.next()) {
                        UserModel userModel = new UserModel();

                        userModel.setId(resultSet.getInt(1));
                        userModel.setUsername(resultSet.getString(2));
                        userModel.setPassword(resultSet.getString(3));
                        userModel.setLastLogin(resultSet.getString(4));

                        dataList.add(userModel);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    public UserModel showUser(String username, String password) {
        UserModel model = null;
        Statement statement = connection.createStatement();

        password = Base64.getEncoder().encodeToString(password.getBytes());

        if (statement != null) {
            String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (resultSet != null) {
                model = new UserModel();

                try {
                    while (resultSet.next()) {
                        model.setId(resultSet.getInt(1));
                        model.setUsername(resultSet.getString(2));
                        model.setPassword(resultSet.getString(3));
                        model.setLastLogin(resultSet.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return model;
    }

    public UserModel showUser(String username) {
        UserModel model = null;
        Statement statement = connection.createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM user WHERE username = '" + username + "'";
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (resultSet != null) {
                model = new UserModel();

                try {
                    while (resultSet.next()) {
                        model.setId(resultSet.getInt(1));
                        model.setUsername(resultSet.getString(2));
                        model.setPassword(resultSet.getString(3));
                        model.setLastLogin(resultSet.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return model;
    }

    public UserModel showUser(int id) {
        UserModel model = null;
        Statement statement = connection.createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM user WHERE id = " + id;
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (resultSet != null) {
                model = new UserModel();

                try {
                    while (resultSet.next()) {
                        model.setId(resultSet.getInt(1));
                        model.setUsername(resultSet.getString(2));
                        model.setPassword(resultSet.getString(3));
                        model.setLastLogin(resultSet.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return model;
    }

    public int login(HttpSession session, String username, String password) {
        Statement statement = connection.createStatement();
        int hasil = -1;

        try {
            UserModel model = showUser(username, password);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");

            Date date = new Date();
            String sql = "UPDATE user SET last_login = '" + format.format(date) + "' WHERE id = " + model.getId();

            hasil = statement.executeUpdate(sql);

            if (hasil == 1) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasil;
    }
}
