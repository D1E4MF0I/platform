package com.than.test;

import com.than.controller.chat.ChatHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainTest {

    @Autowired
    ChatHandler handler;


    @Test
    public void pathTest(){
        System.out.println(handler.toString());
    }


}
