package com.than;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Than
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class App {
    /**
     * @author Than
     *主函数
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
