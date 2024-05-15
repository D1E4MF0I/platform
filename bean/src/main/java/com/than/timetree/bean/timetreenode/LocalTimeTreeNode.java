package com.than.timetree.bean.timetreenode;

import com.than.timetree.bean.TimeTreeNode;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class LocalTimeTreeNode extends TimeTreeNode {
    public LocalTimeTreeNode(String local) {
        this.local = local;
        this.type = TTN_LOCAL;

        this.time = Timestamp.from(Instant.now());
    }
}
