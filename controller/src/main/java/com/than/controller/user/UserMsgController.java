package com.than.controller.user;


import com.than.base.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 * <p>获取用户信息</p>
 * <p>用户信息分为两种: 个人信息和他人信息</p>
 */
@RestController
@RequestMapping("/user_msg")
public class UserMsgController {

    /**
     * <p>获取个人信息,无参数,但是需要在请求头中附带cookie</p>
     * @return 返回个人信息
     */
    @GetMapping("/personal")
    public Result getPersonalMsg(){

        return new Result();
    }

    /**
     *
     * @param username 用户的名称
     * @return 返回用户信息
     */
    @PostMapping("/others_msg")
    public Result getOthersMsgByName(@RequestParam("username")String username){


        return new Result();
    }

    /**
     *
     * @param id 用户账号
     * @return 返回用户信息
     */
    @PostMapping("/others_msg")
    public Result getOthersMsgById(@RequestParam("user_id")String id){


        return new Result();
    }


}
