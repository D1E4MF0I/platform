package com.than.dao.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
public class UserBean {
    // 必须
    private String name;
    @JsonIgnore
    private String password;

    private String headshot;
    private String background;
    private String signature;

    // 自动
    private String account;
    private Timestamp create_time;


    public UserBean() {
        account = String.valueOf(System.nanoTime());
        create_time = new Timestamp(System.currentTimeMillis());
    }

    public UserBean(String name, String password) {
        this();
        this.name = name;
        this.password = password;
    }
}
