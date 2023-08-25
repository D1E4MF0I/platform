package com.than.user;

import com.than.base.Code;
import com.than.base.Result;
import com.than.controller.bean.UserPersonalMsgBean;
import com.than.jwt.JWTUtil;
import com.than.time.TimeUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Than
 * @package: com.than.user
 * @className: UserService
 * @description: 用户管理的service层, 配合控制层使用, 登录等操作的具体逻辑在这里实现
 * @date: 2023/8/25 14:54
 */
@Service
public class UserService {

    public Result signUpUser(String user, String pwd) {
        // TODO: 2023/8/25 将数据存入数据库,并获取id
        int id = 1;

        String token = JWTUtil.getToken(Map.of(String.valueOf(id), user, "creat-time", String.valueOf(TimeUtil.getTime())));

        return new Result(Code.OK, initUser(), token);
    }

    public Result logInByPwd() {

        return new Result();
    }

    public Result logInByCookie() {

        return new Result();
    }

    private UserPersonalMsgBean initUser() {
        return null;
    }


}
