package com.than.controller.comment;

import com.than.base.Result;
import com.than.controller.bean.CommentBean;
import com.than.service.comment.UserOwnCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Than
 * <p>用户自己的评论管理控制层,发布评论等操作在这里进行</p>
 * <strong>此类中所有接口需要传入用户cookie</strong>
 */
@RestController
@RequestMapping("/comment/own")
public class UserOwnCommentController {

    @Autowired
    private UserOwnCommentService userOwnCommentService;

    /**
     * <p>发送一个评论,此接口可以用于评论帖子,也可以用于评论其他用户的评论</p>
     * @param bean 评论实体
     * @return 返回是否发送成功
     */
    @PostMapping("/send_comment")
    public Result addComment(@RequestBody CommentBean bean) {
        return new Result();
    }

    /**
     * <p>删除一个评论</p>
     * @param bean 评论实体
     * @return 返回是否删除成功
     */
    @PostMapping("/delete_comment")
    public Result deleteComment(@RequestBody CommentBean bean) {
        return new Result();
    }


}
