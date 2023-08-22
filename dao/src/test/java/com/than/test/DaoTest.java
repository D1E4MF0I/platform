package com.than.test;

import com.than.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DaoTest {
    @Autowired
    TestMapper mapper;

    @Test
    void getMapper(){
        System.out.println(mapper.findAll());
    }

}
