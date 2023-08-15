package com.than.controller.comment;

import com.than.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Than
 * <p>评论的控制层,用于获取帖子评论等操作</p>
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    /**
     * <p>获取一个帖子下面的所有评论</p>
     * @param id 帖子id
     * @return 返回所有评论
     */
    @GetMapping("/get_all_comments_by_post_id")
    public Result getCommentsByPostId(@RequestParam("post_id")String id){
        return new Result();
    }

    /**
     * <p>获取某个用户的所有评论</p>
     * @param id 用户id
     * @return 返回所有评论
     */
    @GetMapping("/get_all_comments_by_user_id")
    public Result getCommentsByUserId(@RequestParam("user_id")String id){
        return new Result();
    }

}
