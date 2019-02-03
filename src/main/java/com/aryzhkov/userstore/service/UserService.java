package com.aryzhkov.userstore.service;

import com.aryzhkov.userstore.dao.UserStoreDao;
import com.aryzhkov.userstore.entity.User;

import java.util.List;

public class UserService implements IUserService {

    private UserStoreDao userStoreDao;

    @Override
    public List<User> getUsers() {
        return userStoreDao.getUsers();
    }

    @Override
    public int InsertUser(User user) {
        return userStoreDao.InsertUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userStoreDao.getUserById(id);
    }

    @Override
    public void UpdateUser(User user) {
        userStoreDao.UpdateUser(user);
    }

    @Override
    public void DeleteUser(int id) {
        userStoreDao.DeleteUser(id);
    }

    public void setUserStoreDao(UserStoreDao userStoreDao) {
        this.userStoreDao = userStoreDao;
    }
}
