package com.than.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.than"},exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.than")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
