package com.aryzhkov.userstore.dao;

import com.aryzhkov.userstore.dao.connection.JdbcConnection;
import com.aryzhkov.userstore.dao.mapper.UserRowMapper;
import com.aryzhkov.userstore.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserStoreDao implements IUserStoreDao {

    private final String SELECT_ALL = "SELECT id, firstname, lastname, salary FROM user;";

    public List<User> getUsers() {
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                UserRowMapper userRowMapper = new UserRowMapper();
                User user = userRowMapper.mapRowUser(resultSet);
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException("Getting all users are failed", e);
        }
    }

    public List<User> getUserById(int id) {
        return null;
    }

    public void UpdateUser(User user) {

    }

    public void DeleteUser(int id) {

    }

    public int InsertUser(User user) {
        return 0;
    }
}
