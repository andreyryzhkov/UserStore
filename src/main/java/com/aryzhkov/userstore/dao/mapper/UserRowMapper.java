package com.aryzhkov.userstore.dao.mapper;

import com.aryzhkov.userstore.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper {

    public User mapRowUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("ID"));
        user.setFirstName(resultSet.getString("FIRSTNAME"));
        user.setLastName(resultSet.getString("LASTNAME"));
        user.setSalary(resultSet.getDouble("SALARY"));
      //  user.setDateOfBirth(resultSet.getDate("DATEOFBIRTH"));

        return user;
    }
}
