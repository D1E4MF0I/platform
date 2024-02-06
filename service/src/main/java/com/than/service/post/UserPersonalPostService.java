package com.than.service.post;

import com.than.aspect.AutoToken;
import com.than.aspect.args.AutoTokenArgument;
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
 * @className: UserPersonalPostService
 * @description: 用户个人帖子的service
 * @date: 2023/8/30 21:40
 */
@Service
public class UserPersonalPostService {
    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;
    public Result addPost(PersonalPostBean bean) {
        Result result = new Result();
        try {
            boolean res = postDao.insertPersonalPostBean(bean);
            if(res){
                result.setCode(Code.DATABASE_POST_INSERT_SUCCESS);
                result.setMsg("添加贴子成功");
            }else{
                result.setCode(Code.DATABASE_POST_INSERT_ERROR);
                result.setMsg("添加帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误" + e.getStackTrace());
        }
        return result;
    }

    public Result deletePost(String id) {
        Result result = new Result();
        try {
            boolean res = postDao.deletePersonalPostBeanById(Long.valueOf(id));
            if(res){
                result.setCode(Code.DATABASE_POST_DELETE_SUCCESS);
                result.setMsg("删除贴子成功");
            }else{
                result.setCode(Code.DATABASE_POST_DELETE_ERROR);
                result.setMsg("删除帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误" + e.getStackTrace());
        }
        return result;
    }

    public Result getAllOwnPost(String token) {
        Result result = new Result();
        UserBean userBean = userDao.getByUserToken(token);
        try {
            List<PersonalPostBean> postBeans = postDao.selectAllPersonalPostBeansByAuthorId(userBean.getId());
            if(postBeans.size() > 0){
                result.setCode(Code.DATABASE_POST_SELECT_SUCCESS);
                result.setMsg("获取个人所有贴子成功");
            }else{
                result.setCode(Code.DATABASE_POST_SELECT_ERROR);
                result.setMsg("获取个人所有帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误" + e.getStackTrace());
        }
        return result;
    }

    public Result updatePost(PersonalPostBean bean) {
        Result result = new Result();
        try {
            boolean res = postDao.updatePersonalPostBean(bean);
            if(res){
                result.setCode(Code.DATABASE_POST_UPDATE_SUCCESS);
                result.setMsg("更新贴子成功");
            }else{
                result.setCode(Code.DATABASE_POST_UPDATE_ERROR);
                result.setMsg("更新帖子失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(Code.DATABASE_ERROR);
            result.setMsg("数据库错误" + e.getStackTrace());
        }
        return result;
    }
}