package com.than.service.user;

import com.than.aspect.AutoToken;
import com.than.aspect.args.AutoTokenArgument;
import com.than.base.Code;
import com.than.base.Result;
import com.than.dao.bean.UserBean;
import com.than.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.user
 * @className: UserMsgController
 * @description: 用户信息service
 * @date: 2023/8/30 18:22
 */
@Service
public class UserMsgService {

    @Autowired
    private UserDao userDao;

    private String tokenGet(AutoTokenArgument[] token){
        return token[0].getArg();
    }

    @AutoToken
    public Result getPersonalMsg(AutoTokenArgument... token) {
        UserBean userBean = userDao.getByUserToken(tokenGet(token));
        Result res = new Result();
        if(userBean != null){
            res.setExtraInformation(userBean);
            res.setMsg("根据Token获取用户信息成功");
            res.setCode(Code.DATABASE_USER_SELECT_SUCCESS);
        }else{
            res.setCode(Code.DATABASE_USER_SELECT_ERROR);
            res.setMsg("根据Token获取用户信息失败");
        }
        return res;
    }

    public Result getOthersMsgByName(String username) {
        // TODO: 2023/8/30 获取他人信息
        Result result = new Result();
        UserBean userBean = null;
        try {
            userBean = userDao.getByUsername(username);
            if(userBean != null){
                result.setCode(Code.DATABASE_USER_SELECT_SUCCESS);
                result.setMsg("数据库获取用户信息成功");
            }else{
                result.setCode(Code.DATABASE_USER_SELECT_ERROR);
                result.setMsg("数据库获取用户信息失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库获取出错" + e.getStackTrace());
        }
        return result;
    }

    public Result getOthersMsgById(String id) {
        // TODO: 2023/8/30 根据id获取他人信息
        Result result = new Result();
        UserBean userBean = null;
        try {
            userBean = userDao.getById(Long.valueOf(id));
            if(userBean != null){
                result.setCode(Code.DATABASE_USER_SELECT_SUCCESS);
                result.setMsg("数据库获取用户信息成功");
            }else{
                result.setCode(Code.DATABASE_USER_SELECT_ERROR);
                result.setMsg("数据库获取用户信息失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库获取出错" + e.getStackTrace());
        }
        return result;
    }

}
