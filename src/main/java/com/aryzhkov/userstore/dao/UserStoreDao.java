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

    private final String SELECT_ALL = "SELECT id, firstname, lastname, salary FROM user";


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

    public User getUserById(int id) {
        String select = SELECT_ALL + " WHERE id = " + id;

        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {

            UserRowMapper userRowMapper = new UserRowMapper();
            return userRowMapper.mapRowUser(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("Getting user by ID is failed", e);
        }
    }

    public void UpdateUser(User user) {
        StringBuilder updateBuilder = new StringBuilder();
        updateBuilder.append("UPDATE user SET ");
        updateBuilder.append("firstname = '").append(user.getFirstName()).append("'").append(",");
        updateBuilder.append("lastname = '").append(user.getLastName()).append("'").append(",");
        updateBuilder.append("salary = ").append(user.getSalary());
        updateBuilder.append(" WHERE id = ").append(user.getId());

        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(updateBuilder.toString());

        } catch (SQLException e) {
            throw new RuntimeException("Update user is failed", e);
        }
    }

    public void DeleteUser(int id) {
        StringBuilder deleteBuilder = new StringBuilder();
        deleteBuilder.append("DELETE FROM user WHERE id = ").append(id);
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(deleteBuilder.toString());

        } catch (SQLException e) {
            throw new RuntimeException("Delete user is failed", e);
        }
    }

    public int InsertUser(User user) {
        StringBuilder insertBuilder = new StringBuilder();
        insertBuilder.append("INSERT INTO user(firstname, lastname, salary) VALUES (");
        insertBuilder.append("'").append(user.getFirstName()).append("'").append(",");
        insertBuilder.append("'").append(user.getLastName()).append("'").append(",");
        insertBuilder.append(user.getSalary()).append(");");

        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(insertBuilder.toString());
        } catch (SQLException e) {
            throw new RuntimeException("Insert user is failed", e);
        }
    }
}