package com.than.timetree.bean.timetreenode;

import com.than.timetree.bean.TimeTreeNode;

import java.sql.Timestamp;
import java.time.Instant;

public class OperateTimeTreeNode extends TimeTreeNode {
    private String operate;

    public OperateTimeTreeNode(String operate, Long userId) {
        this.operate = operate;
        this.type = TTN_OPERATE;
        this.userId = userId;

        this.time = Timestamp.from(Instant.now());
    }

    public OperateTimeTreeNode(String operate, String local, Long userId){
        this(operate, userId);

        this.local = local;
    }

    public OperateTimeTreeNode(Long id, Long userId, Timestamp time, String local, String type, String operate) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.local = local;
        this.type = type;
        this.operate = operate;
    }
}
