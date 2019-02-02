package com.aryzhkov.userstore.dao;

import com.aryzhkov.userstore.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UserStoreDaoTest {

    @Test
    public void testGetUsers() {
        UserStoreDao userStoreDao = new UserStoreDao();
        List<User> users = userStoreDao.getUsers();

        for (User user : users) {
            assertNotEquals(user.getId(), 0);
            assertNotNull(user.getFirstName());
            assertNotEquals(user.getSalary(), 0);
        }
    }
}