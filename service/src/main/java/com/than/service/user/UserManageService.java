package com.than.service.user;

import com.than.aspect.Argument;
import com.than.base.Result;
import com.than.dao.bean.UserBean;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.user
 * @className: UserManageService
 * @description: 用户管理的service
 * @date: 2023/8/30 18:06
 */
@Service
public class UserManageService {


    public Result changeUsername(Argument name){
        // TODO: 2023/8/30 根据token从数据库, 修改用户名



        return null;
    }

    public Result changeAccountPicture(Argument url){
        // TODO: 2023/8/30 根据token从数据库修改用户头像


        return null;
    }

    public Result changeAccountBackground(Argument url){
        // TODO: 2023/8/30 根据token从数据库修改背景图片



        return null;
    }


    public Result changeUserSignature(Argument signature){
        // TODO: 2023/8/30 根据用户token从数据库修改用户签名



        return null;
    }

    public Result changeUserRegion(Argument region) {
        // TODO: 2023/8/30 根据token从数据库修改用户地区



        return new Result();
    }

    public Result changeUserMsgByJson(UserBean bean) {
        // TODO: 2023/8/30 根据token从数据修改用户信息



        return new Result();
    }

    public Result changeUserType(Argument type) {
        // TODO: 2023/8/30 从token从数据库修改用户类型



        return new Result();
    }



}
