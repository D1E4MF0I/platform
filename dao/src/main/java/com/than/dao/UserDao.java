package com.than.dao;

import com.than.dao.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    /**
     * 查询 根据账号查询具体账户
     * @param account 账户号
     * @return UserBean 账户
     */
    @Select("select * from user_tbl where account = #{account}")
    UserBean getByAccount(String account);

    /**
     * 添加 新账户
     * @param userBean
     * @return 操作数量，用于判断操作结果
     */
    @Insert("INSERT INTO `platformDB`.`user_tbl` (`account`, `password`, `headshot`, `background`, `signature`, `create_time`) VALUES (#{userBean.account}, #{userBean.password}, #{userBean.headshot}, #{userBean.background}, #{userBean.signature}, #{userBean.create_time})")
    int insertUser(@Param("userBean") UserBean userBean);
}
