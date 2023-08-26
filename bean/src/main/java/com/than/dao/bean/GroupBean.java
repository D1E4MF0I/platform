package com.than.dao.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
public class GroupBean {
    private String group_account;
    private String group_creator_account;
    private Timestamp group_create_time;
    private String group_sizes;
    private String group_max_sizes;
    private String group_headshot;
    private String group_background;
    private String group_signature;
}
