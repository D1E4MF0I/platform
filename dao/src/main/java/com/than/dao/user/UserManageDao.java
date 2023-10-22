package com.than.dao.user;

import com.than.dao.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author Than
 * @package: com.than.dao.user
 * @className: UserManageDao
 * @description: 用户管理接口的dao类
 * @date: 2023/10/20 18:02
 */
@Mapper
public interface UserManageDao {

    @Update("update `user_tbl` set name=#{name} where token=#{token}")
    int updateNameByToken(String token,String name);


    @Update("update `user_tbl` set headshot=#{url} where token=#{token}")
    int updateAccountPictureByToken(String token,String url);


    @Update("update `user_tbl` set background=#{url} where token=#{token}")
    int updateAccountBackgroundByToken(String token,String url);


    @Update("update `user_tbl` set signature=#{signature} where token=#{token}")
    int updateUserSignatureByToken(String token,String signature);


    @Update("update `user_tbl` set region=#{region} where token=#{token}")
    int updateUserRegionByToken(String token,String region);


    @Update("update `user_tbl` set type=#{type} where token=#{token}")
    int updateUserTypeByToken(String token,String type);


    @Update("UPDATE `user_tbl` SET `password` = #{userBean.password}, `headshot` = #{userBean.headshot}, `background` = #{userBean.background}, `signature` = #{userBean.signature}, `create_time` = #{userBean.create_time}, `type` = #{userBean.type}, `region` = #{userBean.region} WHERE `name` = #{userBean.name}")
    int updateUserMsgByToken(UserBean userBean);


}
