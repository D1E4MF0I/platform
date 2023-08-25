package com.than.test;


import com.than.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testSQL(){
        System.out.println(userDao.testSQL());
    }
}
