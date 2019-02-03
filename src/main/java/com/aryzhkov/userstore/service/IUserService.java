package com.aryzhkov.userstore.service;

import com.aryzhkov.userstore.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    int InsertUser(User user);

    User getUserById(int id);

    void UpdateUser(User user);

    void DeleteUser(int id);
}
