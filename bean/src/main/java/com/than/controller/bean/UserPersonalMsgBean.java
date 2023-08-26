package com.than.controller.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserPersonalMsgBean {

    @JsonIgnore
    private String token;


}
