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
}
