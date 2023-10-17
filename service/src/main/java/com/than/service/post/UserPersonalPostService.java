package com.than.service.post;

import com.than.base.Result;
import com.than.controller.bean.PersonalPostBean;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.service.post
 * @className: UserPersonalPostService
 * @description: 用户个人帖子的service
 * @date: 2023/8/30 21:40
 */
@Service
public class UserPersonalPostService {

    public Result addPost(PersonalPostBean bean) {
        // TODO: 2023/10/15 将帖子加入数据库

        return new Result();
    }

    public Result deletePost(String id) {
        // TODO: 2023/10/15  根据id删除post

        return new Result();
    }

    public Result getAllOwnPost() {
        // TODO: 2023/10/15  获取个人的所有帖子

        return new Result();
    }

    public Result updatePost(PersonalPostBean bean) {
        // TODO: 2023/10/15  重新编辑post

        return new Result();
    }


}
