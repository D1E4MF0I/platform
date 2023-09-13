package com.than.dao.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
public class GroupBean {
    // 必须
    private String group_name;
    private String group_creator_account;
    private Integer group_sizes;
    private Integer group_max_sizes;

    private String group_headshot;
    private String group_background;
    private String group_signature;

    // 自动
    private String group_account;
    private Timestamp group_create_time;

    private String group_owner_account;
    private String group_region;
    private String group_tags;


    public GroupBean() {
        group_account = String.valueOf(System.nanoTime());

        group_create_time = new Timestamp(System.currentTimeMillis());
    }

    public GroupBean(String group_name, String group_creator_account, Integer group_sizes, Integer group_max_sizes) {
        this();
        this.group_name = group_name;
        this.group_creator_account = group_creator_account;
        this.group_sizes = group_sizes;
        this.group_max_sizes = group_max_sizes;
        this.group_owner_account = group_creator_account;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_creator_account() {
        return group_creator_account;
    }

    public void setGroup_creator_account(String group_creator_account) {
        this.group_creator_account = group_creator_account;
    }

    public Integer getGroup_sizes() {
        return group_sizes;
    }

    public void setGroup_sizes(Integer group_sizes) {
        this.group_sizes = group_sizes;
    }

    public Integer getGroup_max_sizes() {
        return group_max_sizes;
    }

    public void setGroup_max_sizes(Integer group_max_sizes) {
        this.group_max_sizes = group_max_sizes;
    }

    public String getGroup_headshot() {
        return group_headshot;
    }

    public void setGroup_headshot(String group_headshot) {
        this.group_headshot = group_headshot;
    }

    public String getGroup_background() {
        return group_background;
    }

    public void setGroup_background(String group_background) {
        this.group_background = group_background;
    }

    public String getGroup_signature() {
        return group_signature;
    }

    public void setGroup_signature(String group_signature) {
        this.group_signature = group_signature;
    }

    public String getGroup_account() {
        return group_account;
    }

    public void setGroup_account(String group_account) {
        this.group_account = group_account;
    }

    public Timestamp getGroup_create_time() {
        return group_create_time;
    }

    public void setGroup_create_time(Timestamp group_create_time) {
        this.group_create_time = group_create_time;
    }

    public String getGroup_owner_account() {
        return group_owner_account;
    }

    public void setGroup_owner_account(String group_owner_account) {
        this.group_owner_account = group_owner_account;
    }

    public String getGroup_region() {
        return group_region;
    }

    public void setGroup_region(String group_region) {
        this.group_region = group_region;
    }

    public String getGroup_tags() {
        return group_tags;
    }

    public void setGroup_tags(String group_tags) {
        this.group_tags = group_tags;
    }
}
