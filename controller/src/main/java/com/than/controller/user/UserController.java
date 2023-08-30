package com.than.controller.user;

import com.than.base.Result;
import com.than.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>用户相关的控制层，比如注册,登录等操作在这里完成</p>
 *
 * @author Than
 */
@RestController
@RequestMapping(("/user"))
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 注册账号
     *
     * @param user 账号
     * @param pwd  密码
     * @return 是否注册成功, 用户cookie, 以及用户信息
     */
    @PostMapping("/sign_up")
    public Result signUpUser(@RequestParam("user") String user, @RequestParam("pwd") String pwd, HttpServletResponse response) {
        Result result = service.signUpUser(user, pwd);
        response.addHeader("token", result.getExtraInformation().toString());
        return result;
    }

    /**
     * 通过账号密码登录
     *
     * @param user 账号
     * @param pwd  密码
     * @return 是否登录成功, 用户cookie, 以及用户信息
     */
    @PostMapping("/login_pwd")
    public Result logInByPwd(@RequestParam("user") String user, @RequestParam("pwd") String pwd,HttpServletResponse response) {

        Result result = service.logInByPwd(user, pwd);
        response.addHeader("token", result.getExtraInformation().toString());

        return result;
    }

    /**
     * <p>通过cookie登录</p>
     * <strong>cookie通过请求头发送,如果cookie为空,则无法进入这个方法</strong>
     *
     * @return 是否登录成功, 以及用户信息, 请求头返回token, 如果cookie即将过期, 将自动更新cookie
     */
    @GetMapping("/login_cookie")
    public Result logInByCookie(HttpServletResponse response, HttpServletRequest request) {
        String token = request.getHeader("token");
        Result result = service.logInByCookie(token);
        response.addHeader("token", result.getExtraInformation().toString());

        return new Result();
    }


}
