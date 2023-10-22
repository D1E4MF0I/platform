package com.than.service.user;

import com.than.base.Code;
import com.than.base.Result;
import com.than.dao.user.UserDao;
import com.than.dao.bean.UserBean;
import com.than.jwt.JWTUtil;
import com.than.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserDao userDao;

    public Result signUpUser(String user, String pwd) {

        if (userDao.isUserNameExist(user)) {
            return new Result(Code.FAIL, "用户已经存在！");
        } else if (user.length() > 50) {
            return new Result(Code.FAIL, "用户名过长！");
        }
        UserBean bean = initUser(user, pwd);
        userDao.insertUser(bean);
        return new Result(Code.OK, bean, bean.getToken());
    }

    public Result logInByPwd(String user, String pwd) {
        boolean isRight = verifyPwd(user, pwd);
        Result result;

        if (isRight) {
            UserBean userMsg = getUserMsg(user);
            result = new Result(Code.OK, userMsg, userMsg.getToken());
        } else {
            result = new Result(Code.FAIL, "密码错误", null);
        }

        return result;
    }

    public Result logInByCookie(String token) {
        UserBean userMsg = getUserMsg(token);
        String newToken = JWTUtil.refreshTheToken(token);
        userMsg.setToken(newToken);
        return new Result(Code.OK, userMsg, newToken);
    }


    private String getToken(String account, String user) {
        return JWTUtil.getToken(Map.of(account, user, "creat-time", String.valueOf(TimeUtil.getTime())));
    }


    private UserBean initUser(String user, String pwd) {
        UserBean bean = new UserBean(user, pwd);
        String account = bean.getAccount();
        String token = getToken(account, user);
        bean.setToken(token);
        bean.setSignature("懒未设");
        // TODO: 2023/10/18 完善默认头像等信息
        return bean;
    }

    private UserBean getUserMsg(String userVerifyCode) {
        if (userVerifyCode.length() > 50) {
            return userDao.getByUserToken(userVerifyCode);
        }
        return userDao.getByUsername(userVerifyCode);
    }

    private boolean verifyPwd(String user, String pwd) {
        UserBean userBean = getUserMsg(user);

        if (userBean != null) {
            //副作用，更新token
            String token = getToken(userBean.getAccount(), userBean.getName());
            userDao.updateToken(userBean.getName(), token);
            return pwd.equals(userBean.getPassword());
        }
        return false;
    }

}
