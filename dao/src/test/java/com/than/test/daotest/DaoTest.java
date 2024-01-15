package com.than.test.daotest;


import com.than.controller.bean.FileBean;
import com.than.controller.bean.PersonalPostBean;
import com.than.dao.FileDao;
import com.than.dao.GroupDao;
import com.than.dao.PostDao;
import com.than.dao.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    void testBool(){

        System.out.println(userDao.isUserNameExist("2345"));

    }

    @Autowired
    FileDao fileDao;
    @Test
    void testFile(){
        System.out.println(fileDao.selectById(1));
        FileBean fileBean = new FileBean();
        fileBean.setPath("1");
        fileBean.setTime(String.valueOf(Timestamp.from(Instant.now())));
        fileBean.setUrl("123");
        fileDao.insert(fileBean);
        System.out.println(fileDao.selectAll());
        fileDao.deleteById(1);
        System.out.println(fileDao.selectAll());
    }
}
