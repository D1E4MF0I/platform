package com.than.timetree.bean.timetreenode;

import com.than.controller.bean.PersonalPostBean;
import com.than.timetree.bean.TimeTreeNode;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class PostTimeTreeNode extends TimeTreeNode {
    // TODO:生成专属ID（根据数据库存储自生成）
    private Long id;
    // 指向所对应帖子Id，需要时候根据ID进行查询
    private Long postId;

    /*
    时间处理：
    Post：以Post生成时间为主
    Action，Local：以当前时间为主
    * */

    // 地点
    private String local;
    // 简要内容
    private String content;
    // 题目
    private String title;


    // TODO:图片信息存储

    public PostTimeTreeNode(PersonalPostBean ppb){
        this.postId = ppb.getId();

        this.time = Timestamp.from(ppb.getCreateTime().toInstant());
        this.content = ppb.getContent();
        this.title = ppb.getTitle();
    }

    public PostTimeTreeNode(PersonalPostBean ppb, String local){
        this(ppb);
        this.local = local;
    }

}
