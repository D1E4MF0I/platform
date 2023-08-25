package com.than.user;

import com.than.base.Result;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.user
 * @className: UserService
 * @description: 用户管理的service层,配合控制层使用,登录等操作的具体逻辑在这里实现
 * @date: 2023/8/25 14:54
 */
@Service
public class UserService {

    public Result signUpUser(){

        return new Result();
    }

    public Result logInByPwd(){

        return new Result();
    }

    public Result logInByCookie(){
        return new Result();
    }



}
