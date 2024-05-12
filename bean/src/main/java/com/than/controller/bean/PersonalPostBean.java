package com.than.controller.bean;

import lombok.Data;

import java.util.Date;

@Data
public class PersonalPostBean {
    private Long id; // 帖子的唯一标识符
    private String title; // 帖子的标题
    private String content; // 帖子的内容
    private Date createTime; // 帖子的创建时间
    private Date updateTime; // 帖子的最后更新时间
    private Long authorId; // 发起人的ID
    // TODO:图片信息存储
}

