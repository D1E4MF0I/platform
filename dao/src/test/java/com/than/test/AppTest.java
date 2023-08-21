package com.than.test;


import com.than.main.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class AppTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testSQL(){
        System.out.println(userDao.testSQL());
    }
}
