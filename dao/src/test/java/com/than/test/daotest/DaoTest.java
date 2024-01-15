package com.than.test.daotest;


import com.than.dao.GroupDao;
import com.than.dao.PostDao;
import com.than.dao.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    void testBool(){

        System.out.println(userDao.isUserNameExist("2345"));

    }
}
