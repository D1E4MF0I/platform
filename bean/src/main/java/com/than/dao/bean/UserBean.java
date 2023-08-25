package com.than.dao.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserBean {
    private String account;
    @JsonIgnore
    private String password;
    private String headshot;
    private String background;
    private String signature;
    private String create_time;
}
