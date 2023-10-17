package com.than.test;


import com.than.controller.chat.ChatHandler;
import com.than.service.post.UserPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes = com.than.App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeTest {

    @Autowired
    ChatHandler handler;
    @Autowired
    UserPostService service;

    @Test
    public void pathTest(){
        System.out.println(handler.toString());
    }



}
