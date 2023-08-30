package com.than.service.comment;

import com.than.base.Result;
import com.than.controller.bean.CommentBean;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.service.comment
 * @className: UserOwnCommentService
 * @description: 用户个人评论的service
 * @date: 2023/8/30 21:42
 */
@Service
public class UserOwnCommentService {

    public Result addComment(CommentBean bean) {
        return new Result();
    }

    public Result deleteComment( CommentBean bean) {
        return new Result();
    }

}
