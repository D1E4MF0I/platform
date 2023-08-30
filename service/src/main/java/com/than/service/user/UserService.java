package com.than.service.user;

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
        // TODO: 2023/8/25 将数据存入数据库,并获取id, 判断账号名是否符合规范(长度小于50)
        int id = 1;

        String token = JWTUtil.getToken(Map.of(String.valueOf(id), user, "creat-time", String.valueOf(TimeUtil.getTime())));

        return new Result(Code.OK, initUser(), token);
    }

    public Result logInByPwd(String user, String pwd) {
        boolean isRight = verifyPwd(user, pwd);
        Result result;

        if (isRight) {
            UserPersonalMsgBean userMsg = getUserMsg(user);
            result = new Result(Code.OK, getUserMsg(user), userMsg.getToken());
        } else {
            result = new Result(Code.FAIL, "密码错误", null);
        }

        return result;
    }

    public Result logInByCookie(String token) {

        UserPersonalMsgBean userMsg = getUserMsg(token);


        return new Result(Code.OK, userMsg, userMsg.getToken());
    }

    private UserPersonalMsgBean initUser() {
        return null;
    }

    private UserPersonalMsgBean getUserMsg(String userVerifyCode) {
        if (userVerifyCode.length() > 50) {
            return getUserMsgByToken();
        }
        return getUserMsgByUser();
    }

    private UserPersonalMsgBean getUserMsgByUser() {
        return null;
    }

    private UserPersonalMsgBean getUserMsgByToken() {
        return null;
    }

    private boolean verifyPwd(String user, String pwd) {
        // TODO: 2023/8/26 从数据库验证用户账号和密码，返回布尔值
        return false;
    }


}
