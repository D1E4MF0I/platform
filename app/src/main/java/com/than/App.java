package com.than;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Than
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class App {

    /**
     * 主函数
     * @author Than
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
