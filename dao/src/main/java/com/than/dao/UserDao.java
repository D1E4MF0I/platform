package com.than.dao;

import com.than.dao.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 查询 根据账户号查询具体账户
     * @param account 账户号
     * @return UserBean 账户
     */
    @Select("select * from user_tbl where account = #{account}")
    UserBean getByAccount(String account);


    /**
     * 查询 查询所有账户
     * @return 所有账户的列表
     */
    @Select("select * from user_tbl")
    List<UserBean> getAllUsers();


    /**
     * 添加 新账户
     * @param userBean
     * @return 操作数量，用于判断操作结果
     */
    @Insert("INSERT INTO `platformDB`.`user_tbl` (`account`, `password`, `headshot`, `background`, `signature`, `create_time`, `name`) VALUES (#{userBean.account}, #{userBean.password}, #{userBean.headshot}, #{userBean.background}, #{userBean.signature}, #{userBean.create_time}, #{userBean.name})")
    int insertUser(@Param("userBean") UserBean userBean);


    /**
     * 删除 根据账户号指定删除账户
     * @param account
     * @return 操作数量，用于判断结果
     */
    @Delete("delete from user_tbl where account = #{account}")
    int deleteUserByAccount(String account);
}
