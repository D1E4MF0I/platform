package com.than.service.timetreenode;

import com.than.dao.timetreenode.LocalTimeTreeNodeDao;
import com.than.dao.timetreenode.OperateTimeTreeNodeDao;
import com.than.dao.timetreenode.PostTimeTreeNodeDao;
import com.than.timetree.bean.TimeTreeNode;
import com.than.timetree.bean.timetreenode.LocalTimeTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTreeService {
    @Autowired
    LocalTimeTreeNodeDao lttnd;
    @Autowired
    OperateTimeTreeNodeDao ottnd;
    @Autowired
    PostTimeTreeNodeDao pttnd;

    // TODO：实现业务层内容
    public List<TimeTreeNode> getAllTreeNodeByUserId(int userId){
        List<TimeTreeNode> list = new ArrayList<>();

        list.addAll(lttnd.selectAllLocalTimeTreeNodes(userId));
        list.addAll(ottnd.selectAllOperateTimeTreeNodes(userId));
        list.addAll(pttnd.selectAllPostTimeTreeNodes(userId));

        return list;
    }
}
