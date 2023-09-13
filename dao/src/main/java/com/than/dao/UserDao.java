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
     * 添加新账户
     * @param userBean 用户信息
     * @return 操作数量，用于判断操作结果
     */
    @Insert("INSERT INTO `platformDB`.`user_tbl` (`account`, `password`, `name`, `headshot`, `background`, `signature`, `create_time`, `type`, `region`) VALUES (#{userBean.account}, #{userBean.password}, #{userBean.name}, #{userBean.headshot}, #{userBean.background}, #{userBean.signature}, #{userBean.create_time}, #{userBean.type}, #{userBean.region})")
    int insertUser(@Param("userBean") UserBean userBean);



    /**
     * 删除 根据账户号指定删除账户
     * @param account
     * @return 操作数量，用于判断结果
     */
    @Delete("delete from user_tbl where account = #{account}")
    int deleteUserByAccount(String account);

    /**
     * 更新根据账户号更改账户其余信息（账户号无法更改，自动生成且唯一）
     *
     * @param userBean 更新后的用户数据
     * @return 操作数量，用于判断结果
     */
    @Update("UPDATE `platformDB`.`user_tbl` SET `password` = #{userBean.password}, `name` = #{userBean.name}, `headshot` = #{userBean.headshot}, `background` = #{userBean.background}, `signature` = #{userBean.signature}, `create_time` = #{userBean.create_time}, `type` = #{userBean.type}, `region` = #{userBean.region} WHERE `account` = #{userBean.account};")
    int updateUserByAccount(@Param("userBean") UserBean userBean);

    /**
     * 根据 用户账号 查询数据库中是否有此用户
     * @param account
     * @return 用户存在 返回true，否则返回false
     */
    @Select("SELECT COUNT(*) > 0 FROM `platformDB`.`user_tbl` WHERE account = #{account}")
    @ResultType(Boolean.class)
    boolean getUserByAccount(String account);
}
