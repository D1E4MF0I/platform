package com.than.service.user;

import com.than.base.Result;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.user
 * @className: UserMsgController
 * @description: 用户信息service
 * @date: 2023/8/30 18:22
 */
@Service
public class UserMsgController {


    public Result getPersonalMsg() {
        // TODO: 2023/8/30 从数据库获取用户个人信息
        return new Result();
    }

    public Result getOthersMsgByName(String username) {
        // TODO: 2023/8/30 获取他人信息

        return new Result();
    }

    public Result getOthersMsgById(String id) {
        // TODO: 2023/8/30 根据id获取他人信息

        return new Result();
    }

}
