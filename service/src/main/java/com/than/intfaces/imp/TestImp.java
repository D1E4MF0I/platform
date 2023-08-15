package com.than.intfaces.imp;

import com.than.intfaces.Tes;
import org.springframework.stereotype.Component;

@Component
public class TestImp implements Tes {

    @Override
    public void te() {
        System.out.println(2333);
    }
}
