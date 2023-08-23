package com.than.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainTest {


    @Test
    public void pathTest(){
        System.out.println(System.getProperty("user.dir"));
    }


}
