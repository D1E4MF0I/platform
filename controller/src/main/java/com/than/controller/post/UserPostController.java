package com.than.controller.post;

import com.than.base.Result;
import com.than.service.post.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 * <p>用户帖子的管理控制层,获取首页帖子等操作在这里进行</p>
 */
@RestController
@RequestMapping("/post/users")
public class UserPostController {

    @Autowired
    private UserPostService userPostService;

    /**
     * <p>获取所有的帖子,用于首页帖子推荐</p>
     *
     * @return 返回帖子合集
     */
    @GetMapping("/all_posts")
    public Result getAllPost() {

        userPostService.getAllPost();

        return new Result();
    }

    /**
     * <p>获取某一个用户的所有帖子</p>
     *
     * @return 若用户未公开帖子, 返回空, 否则返回所有帖子
     */
    @GetMapping("/others_posts")
    public Result getOtherPosts(@RequestParam("username") String userName) {

        userPostService.getOthersPosts(userName);
        return new Result();
    }

    /**
     * <p>获取某一个帖子详细信息</p>
     *
     * @param id 帖子id
     * @return 返回帖子详细信息
     */
    @PostMapping("/post_detail_msg")
    public Result getPostDetailedMsgById(@RequestParam("post_id") String id) {

        userPostService.getPostDetailedMsgById(id);
        return new Result();
    }


}
