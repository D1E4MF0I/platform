package com.than.controller.user;

import com.than.base.Code;
import com.than.base.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 *
 * 用户相关的控制层，比如注册,登录等操作在这里完成
 */
@RestController
@RequestMapping(("/user"))
public class UserController {
    /**
     * 注册账号
     * @param user 账号
     * @param pwd 密码
     * @return 是否注册成功,用户cookie,以及用户信息
     */
    @PostMapping("/sign_up")
    public Result signUpUser(@RequestParam("user")String user,@RequestParam("pwd")String pwd){


        return new Result(Code.OK,pwd);
    }

    /**
     * 通过账号密码登录
     * @param user 账号
     * @param pwd 密码
     * @return 是否登录成功,用户cookie,以及用户信息
     */
    @PostMapping("/login_pwd")
    public Result logInByPwd(@RequestParam("user")String user,@RequestParam("pwd")String pwd){

        return new Result();
    }

    /**
     * <p>通过cookie登录</p>
     * <strong>cookie通过请求头发送,如果cookie为空,则无法进入这个方法</strong>
     * @return 是否登录成功,以及用户信息
     */
    @GetMapping("/login_cookie")
    public Result logInByCookie(){

        return new Result();
    }


}
