package com.than.timetree.bean;

import com.than.controller.bean.PersonalPostBean;

import java.sql.Timestamp;

public class TimeTreeNode implements Comparable<TimeTreeNode>{
    // TODO:生成专属ID
    private Long id;

    // 指向所对应帖子Id
    private Long postId;
    // TODO:发文，操作，去过哪里
    // 该时间节点时间
    private Timestamp time;
    // 地点
    private String local;

    // 功能：发帖信息
    public TimeTreeNode(PersonalPostBean ppb) {
        this.postId = ppb.getId();
        this.time = Timestamp.from(ppb.getCreateTime().toInstant());
        // TODO:获取地点信息
    }

    // 功能：去过哪里
    public TimeTreeNode(String local){
        this.local = local;
        // TODO:获取时间信息
    }

    // TODO:功能：做过什么操作

    // 默认排序按照时间顺序
    @Override
    public int compareTo(TimeTreeNode o) {
        return this.time.compareTo(o.time);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
