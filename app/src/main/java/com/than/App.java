package com.than;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Than
 */
@SpringBootApplication
public class App {

    public static boolean isTest = true;

    /**
     * @author Than
     * 主函数
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
