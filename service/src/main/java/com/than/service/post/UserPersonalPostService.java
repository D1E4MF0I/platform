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

        return new Result();
    }

    public Result deletePost(String id) {

        return new Result();
    }

    public Result getAllOwnPost() {

        return new Result();
    }

    public Result updatePost(PersonalPostBean bean) {
        return new Result();
    }


}
