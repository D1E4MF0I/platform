package com.than.timetree.bean.timetreenode;

import com.than.timetree.bean.TimeTreeNode;

import java.sql.Timestamp;
import java.time.Instant;

public class OperateTimeTreeNode extends TimeTreeNode {
    private String operate;

    public OperateTimeTreeNode(String operate) {
        this.operate = operate;

        this.time = Timestamp.from(Instant.now());
    }

    public OperateTimeTreeNode(String operate, String local){
        this(operate);

        this.local = local;
    }
}
