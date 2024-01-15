package com.than.service.post;

import com.than.base.Code;
import com.than.base.Result;
import com.than.controller.bean.PersonalPostBean;
import com.than.dao.PostDao;
import com.than.dao.bean.UserBean;
import com.than.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Than
 * @package: com.than.service.post
 * @className: UserPostService
 * @description: 帖子service
 * @date: 2023/8/30 21:41
 */
@Service
public class UserPostService {
    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;

    public Result getAllPost() {
        // TODO: 2023/10/15 从数据库获取所有帖子
        Result result = new Result();
        try {
            List<PersonalPostBean> postBeans = postDao.selectAllPostBeans();
            if(postBeans.size() > 0){
                result.setCode(Code.DATABASE_POST_SELECT_SUCCESS);
                result.setMsg("获取所有贴子成功");
            }else{
                result.setCode(Code.DATABASE_POST_SELECT_ERROR);
                result.setMsg("获取所有帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误");
        }
        return result;
    }

    public Result getOthersPosts(String userName) {
        // TODO: 2023/10/15 从数据库获取某人帖子  根据用户名
        Result result = new Result();
        UserBean userBean = userDao.getByUsername(userName);
        try {
            List<PersonalPostBean> postBeans = postDao.selectAllPersonalPostBeansByAuthorId(userBean.getId());
            if(postBeans.size() > 0){
                result.setCode(Code.DATABASE_POST_SELECT_SUCCESS);
                result.setMsg("获取用户所有贴子成功");
            }else{
                result.setCode(Code.DATABASE_POST_SELECT_ERROR);
                result.setMsg("获取用户所有帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误");
        }
        return result;
    }

    public Result getPostDetailedMsgById(String id) {
        // TODO: 2023/10/15 从数据库获取某帖子详细信息
        Result result = new Result();
        try {
            PersonalPostBean postBean = postDao.selectPersonalPostBeanById(Long.valueOf(id));
            if(postBean != null){
                result.setCode(Code.DATABASE_POST_SELECT_SUCCESS);
                result.setMsg("获取贴子成功");
                // 将获取到的帖子作为额外信息返回
                result.setExtraInformation(postBean);
            }else{
                result.setCode(Code.DATABASE_POST_SELECT_ERROR);
                result.setMsg("获取帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误");
        }
        return result;
    }
}
