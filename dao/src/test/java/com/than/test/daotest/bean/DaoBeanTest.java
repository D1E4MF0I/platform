package com.than.test.daotest.bean;

import com.than.dao.user.UserDao;
import com.than.dao.bean.GroupBean;
import com.than.dao.bean.UserBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DaoBeanTest {
    @Autowired
    UserBean userBean;

    @Autowired
    GroupBean groupBean;

    @Autowired
    UserDao dao;

    /*自动装备测试*/
    @Test
    public void testUserBean(){
    }

    @Test
    public void testGroupBean(){
        System.out.println(dao);
    }
}
