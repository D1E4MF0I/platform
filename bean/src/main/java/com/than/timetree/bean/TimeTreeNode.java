package com.than.timetree.bean;

import com.than.controller.bean.PersonalPostBean;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;

@Data
public class TimeTreeNode implements Comparable<TimeTreeNode>{
    // TODO:生成专属ID
    protected Long id;


    // 节点创建时间
    protected Timestamp time;
    // TODO:发文，操作，去过哪里

    // 功能：发帖信息

    // 功能：去过哪里

    // TODO:功能：做过什么操作

    // 默认排序按照时间顺序
    @Override
    public int compareTo(TimeTreeNode o) {
        return this.time.compareTo(o.time);
    }
}
