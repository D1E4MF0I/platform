package com.than.dao.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.than.UserType;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
public class UserBean {
    private Long id;
    // 必须
    private String name;
    @JsonIgnore
    private String token;
    @JsonIgnore
    private String password;

    private String headshot;
    private String background;
    private String signature;
    private String region;
    private String type;

    // 自动
    private String account;
    private Timestamp create_time;


    public UserBean() {
        account = String.valueOf(System.nanoTime());
        create_time = new Timestamp(System.currentTimeMillis());
        this.type = UserType.ORDINARY.getValue();
    }

    public UserBean(String name, String password) {
        this();
        this.name = name;
        this.password = password;
    }
}
