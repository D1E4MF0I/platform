package com.than.test;

import com.than.service.post.UserPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class TestTes {

    @Autowired
    UserPostService service;



    @Test
    public void pathTest(){
        System.out.println(service);
    }


}
