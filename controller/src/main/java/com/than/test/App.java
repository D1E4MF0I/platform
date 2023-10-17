package com.than.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.than"})
@MapperScan("com.than")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
