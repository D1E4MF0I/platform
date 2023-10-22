package com.than.service.user;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.than.aspect.AutoToken;
import com.than.aspect.args.ArgumentWithTow;
import com.than.aspect.args.AutoTokenArgument;
import com.than.base.Code;
import com.than.base.Result;
import com.than.dao.bean.UserBean;
import com.than.dao.user.UserManageDao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserManageDao dao;

    @AutoToken
    public Result changeUsername(String name, AutoTokenArgument... token){
        int num = dao.updateNameByToken(tokenGet(token), name);
        return universalReturn(num);
    }

    @AutoToken
    public Result changeAccountPicture(String url, AutoTokenArgument... token){
        int num = dao.updateAccountPictureByToken(tokenGet(token), url);
        return universalReturn(num);
    }
    @AutoToken
    public Result changeAccountBackground(String url, AutoTokenArgument... token){
        int num = dao.updateAccountBackgroundByToken(tokenGet(token), url);
        return universalReturn(num);
    }

    @AutoToken
    public Result changeUserSignature(String signature, AutoTokenArgument... token){
        int num = dao.updateUserSignatureByToken(tokenGet(token), signature);
        return universalReturn(num);
    }
    @AutoToken
    public Result changeUserRegion(String region, AutoTokenArgument... token) {
        int num = dao.updateUserRegionByToken(tokenGet(token),region);
        return universalReturn(num);
    }
    @AutoToken
    public Result changeUserType(String type, AutoTokenArgument... token) {
        int num = dao.updateUserTypeByToken(tokenGet(token), type);
        return universalReturn(num);
    }

    public Result changeUserMsgByJson(@NonNull UserBean bean) {
        int num = dao.updateUserMsgByToken(bean);
        return universalReturn(num);
    }


    private Result universalReturn(int num){
        if(num>0){
            return new Result(Code.OK, "修改成功");
        }
        return new Result(Code.FAIL, "修改失败");
    }

    private String tokenGet(AutoTokenArgument[] token){
        return token[0].getArg();
    }



}
