package com.than.test.daotest;


import com.than.dao.UserDao;
import com.than.dao.bean.UserBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;


@SpringBootTest
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    void testUserDao(){
        UserBean userBean = userDao.getByAccount("111");
        System.out.println(userBean);

        UserBean userBean1 = new UserBean();
        userBean1.setAccount("123");
        userBean1.setPassword("123");
        userBean1.setCreate_time(new Timestamp(System.currentTimeMillis()));
        System.out.println(userDao.insertUser(userBean1));
    }
}
