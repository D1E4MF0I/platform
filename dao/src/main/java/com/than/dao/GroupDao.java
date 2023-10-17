package com.than.dao;

import com.than.dao.bean.GroupBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupDao {
    /**
     * 查询 根据群聊号查询具体群聊
     *
     * @param group_account 群聊号
     * @return GroupBean 群聊
     */
    @Select("select * from group_tbl where group_account = #{group_account}")
    GroupBean getByGroupAccount(String group_account);


    /**
     * 查询 查询所有群聊
     *
     * @return 所有群聊的列表
     */
    @Select("select * from group_tbl")
    List<GroupBean> getAllGroups();

    /**
     * 添加 新群聊
     *
     * @param groupBean
     * @return 操作数量，用于判断操作结果
     */
    @Insert("INSERT INTO `platformDB`.`group_tbl` (`group_name`, `group_account`, `group_creator_account`, `group_create_time`, `group_sizes`, `group_max_sizes`, `group_headshot`, `group_background`, `group_signature`, `group_owner_account`, `group_region`, `group_tags`) " +
            "VALUES (#{groupBean.group_name}, #{groupBean.group_account}, #{groupBean.group_creator_account}, " +
            "#{groupBean.group_create_time}, #{groupBean.group_sizes}, #{groupBean.group_max_sizes}, " +
            "#{groupBean.group_headshot}, #{groupBean.group_background}, #{groupBean.group_signature}, " +
            "#{groupBean.group_owner_account}, #{groupBean.group_region}, #{groupBean.group_tags})")
    int insertGroup(@Param("groupBean") GroupBean groupBean);


    /**
     * 删除 根据群聊号删除指定群聊
     *
     * @param group_account
     * @return 操作数量，用于判断结果
     */
    @Delete("delete from group_tbl where group_account = #{group_account}")
    int deleteGroupByGroupAccount(String group_account);

    /**
     * 更新 根据 群聊号 创建群聊账户号 更改群聊其他数据（不包括创始人
     *
     * @param groupBean 更新后的群聊
     * @return 操作数量，用于判断结果
     */
    @Update("UPDATE `platformDB`.`group_tbl` SET `group_name` = #{group.group_name}, `group_create_time` = #{group.group_create_time}, `group_sizes` = #{group.group_sizes}, `group_max_sizes` = #{group.group_max_sizes}, `group_headshot` = #{group.group_headshot}, `group_background` = #{group.group_background}, `group_signature` = #{group.group_signature}, `group_owner_account` = #{group.group_owner_account}, `group_region` = #{group.group_region}, `group_tags` = #{group.group_tags} WHERE `group_account` = #{group.group_account};")
    int updateByGroupAccount(@Param("group") GroupBean groupBean);


    /**
     * 更新 根据group_account更改group_creator_account
     *
     * @param newCreatorAccount
     * @param groupAccount
     * @return 操作数量，用于判断结果
     */
    @Update("UPDATE `platformDB`.`group_tbl` SET `group_creator_account` = #{newCreatorAccount} WHERE `group_account` = #{groupAccount}")
    int updateGroupCreatorAccount(@Param("newCreatorAccount") String newCreatorAccount, @Param("groupAccount") String groupAccount);
}
