package com.than.test;

import com.than.intfaces.Tes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class TestTes {

    @Autowired
    Tes te;

    @Test
    public void print(){
        te.te();
    }


}
