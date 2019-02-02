package com.aryzhkov.userstore.dao;

import com.aryzhkov.userstore.dao.mapper.UserRowMapper;
import com.aryzhkov.userstore.entity.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserRowMapperTest {

    @Test
    public void mapRowUser() throws SQLException, ParseException {
        UserRowMapper userRowMapper = new UserRowMapper();

        ResultSet resultSetMock = mock(ResultSet.class);

        when(resultSetMock.getInt("ID")).thenReturn(1);
        when(resultSetMock.getString("FIRSTNAME")).thenReturn("Ann");
        when(resultSetMock.getString("LASTNAME")).thenReturn("Pak");
        when(resultSetMock.getDouble("SALARY")).thenReturn(20.5);

       // String string = "20.01.2017";
       // DateFormat format = new SimpleDateFormat("DD.MM.YYYY", Locale.ENGLISH);
       // Date date = format.parse(string);

       // when(resultSetMock.getDate("DATEOFBIRTH")).thenReturn((java.sql.Date) date);

        User actualUser = userRowMapper.mapRowUser(resultSetMock);

        assertEquals(1, actualUser.getId());
        assertEquals("Ann", actualUser.getFirstName());
        assertEquals("Pak", actualUser.getLastName());
        assertEquals(20.5, actualUser.getSalary(), 0.0001);
    }
}