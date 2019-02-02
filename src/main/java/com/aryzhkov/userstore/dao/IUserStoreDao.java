package com.aryzhkov.userstore.dao;

import com.aryzhkov.userstore.entity.User;

import java.util.List;

public interface IUserStoreDao {

    public List<User> getUsers();

    public List<User> getUserById(int id);

    public void UpdateUser(User user);

    public void DeleteUser(int id);

    public int InsertUser(User user);

}
