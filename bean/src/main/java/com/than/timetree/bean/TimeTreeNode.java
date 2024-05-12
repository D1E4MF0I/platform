package com.than.timetree.bean;

import com.than.controller.bean.PersonalPostBean;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;

@Data
public class TimeTreeNode implements Comparable<TimeTreeNode>{
    // TODO:生成专属ID
    private Long id;
    // 指向所对应帖子Id
    private Long postId;
    // 该时间节点时间
    private Timestamp time;
    // 地点
    private String local;

    // TODO:发文，操作，去过哪里

    // 功能：发帖信息
    public TimeTreeNode(PersonalPostBean ppb, String local) {
        this.postId = ppb.getId();
        this.time = Timestamp.from(ppb.getCreateTime().toInstant());
        this.local = local;
    }

    // 功能：去过哪里
    public TimeTreeNode(String local){
        this.local = local;
        // 获取时间信息
        this.time = Timestamp.from(Instant.from(LocalTime.now()));
    }

    // TODO:功能：做过什么操作

    // 默认排序按照时间顺序
    @Override
    public int compareTo(TimeTreeNode o) {
        return this.time.compareTo(o.time);
    }
}
