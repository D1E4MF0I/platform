package com.than.test.daotest;


import com.than.controller.bean.FileBean;
import com.than.controller.bean.PersonalPostBean;
import com.than.dao.FileDao;
import com.than.dao.GroupDao;
import com.than.dao.PostDao;
import com.than.dao.timetreenode.LocalTimeTreeNodeDao;
import com.than.dao.timetreenode.OperateTimeTreeNodeDao;
import com.than.dao.timetreenode.PostTimeTreeNodeDao;
import com.than.dao.user.UserDao;
import com.than.timetree.bean.timetreenode.LocalTimeTreeNode;
import com.than.timetree.bean.timetreenode.OperateTimeTreeNode;
import com.than.timetree.bean.timetreenode.PostTimeTreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
public class DaoTest {
    @Autowired
    LocalTimeTreeNodeDao lttnd;
    @Autowired
    OperateTimeTreeNodeDao ottnd;
    @Autowired
    PostTimeTreeNodeDao pttnd;
    @Autowired
    PostDao postDao;

    @Test
    public void test01(){

//        LocalTimeTreeNode localTimeTreeNode = lttnd.selectAllLocalTimeTreeNodes(1).get(0);
//        lttnd.deleteLocalTimeTreeNode(localTimeTreeNode.getId(), localTimeTreeNode.getUserId());
//        System.out.println(lttnd.selectAllLocalTimeTreeNodes(1).get(0).toString());


//        OperateTimeTreeNode operateTimeTreeNode = ottnd.selectAllOperateTimeTreeNodes(1).get(0);
//        ottnd.deleteOperateTimeTreeNode(operateTimeTreeNode.getId(), operateTimeTreeNode.getUserId());
//        System.out.println(ottnd.selectAllOperateTimeTreeNodes(1));

//        PostTimeTreeNode postTimeTreeNode = pttnd.selectAllPostTimeTreeNodes(1).get(0);
//        pttnd.deletePostTimeTreeNode(postTimeTreeNode.getId(), postTimeTreeNode.getUserId());
//        System.out.println(pttnd.selectAllPostTimeTreeNodes(1));
    }

}
