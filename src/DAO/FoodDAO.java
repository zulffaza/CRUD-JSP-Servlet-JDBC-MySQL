package DAO;

import Connection.SessionConnection;
import Model.FoodModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class FoodDAO {
    private SessionConnection connection;

    public FoodDAO() {
        connection = new SessionConnection();
        connection.createConnection();
    }

    public int insertFood(FoodModel foodModel) {
        Statement statement = connection.createStatement();
        int hasil = -1;

        if (statement != null) {
            String sql = "INSERT INTO food(nama, harga, asal, user_id) VALUES('" + foodModel.getNama() + "', " + foodModel.getHarga() + ", '" + foodModel.getAsal() + "', " + foodModel.getUserId() + ")";

            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hasil;
    }

    public int updateFood(FoodModel foodModel) {
        Statement statement = connection.createStatement();
        int hasil = -1;

        if (statement != null) {
            String sql = "UPDATE food SET nama = '" + foodModel.getNama() + "', harga = " + foodModel.getHarga() + ", asal = '" + foodModel.getAsal() + "' WHERE id = " + foodModel.getId();

            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hasil;
    }

    public ArrayList<FoodModel> showFood() {
        ArrayList<FoodModel> dataList = null;
        Statement statement = connection.createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM food";
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
                        FoodModel foodModel = new FoodModel();

                        foodModel.setId(resultSet.getInt(1));
                        foodModel.setNama(resultSet.getString(2));
                        foodModel.setHarga(resultSet.getInt(3));
                        foodModel.setAsal(resultSet.getString(4));
                        foodModel.setLikes(resultSet.getInt(5));
                        foodModel.setDislikes(resultSet.getInt(6));
                        foodModel.setUserId(resultSet.getInt(7));

                        dataList.add(foodModel);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    public FoodModel showFoodAtId(int id) {
        FoodModel model = null;
        Statement statement = connection.createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM food WHERE id = " + id;
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (resultSet != null) {
                model = new FoodModel();

                try {
                    while (resultSet.next()) {
                        model.setId(resultSet.getInt(1));
                        model.setNama(resultSet.getString(2));
                        model.setHarga(resultSet.getInt(3));
                        model.setAsal(resultSet.getString(4));
                        model.setLikes(resultSet.getInt(5));
                        model.setDislikes(resultSet.getInt(6));
                        model.setUserId(resultSet.getInt(7));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return model;
    }

    public int deleteFood(int id) {
        Statement statement = connection.createStatement();
        int hasil = -1;

        if (statement != null) {
            String sql = "DELETE FROM food WHERE id = " + id;

            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hasil;
    }
}