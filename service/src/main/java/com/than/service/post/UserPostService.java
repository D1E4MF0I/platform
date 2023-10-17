package com.than.service.post;

import com.than.base.Result;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.service.post
 * @className: UserPostService
 * @description: 帖子service
 * @date: 2023/8/30 21:41
 */
@Service
public class UserPostService {



    public Result getAllPost() {
        // TODO: 2023/10/15 从数据库获取所有帖子
        return new Result();
    }

    public Result getOthersPosts(String userName) {
        // TODO: 2023/10/15 从数据库获取某人帖子  根据用户名
        return new Result();
    }

    public Result getPostDetailedMsgById(String id) {
        // TODO: 2023/10/15 从数据库获取某帖子详细信息
        return new Result();
    }

}
