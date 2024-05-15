package com.than.dao.timetreenode;

import com.than.timetree.bean.timetreenode.LocalTimeTreeNode;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LocalTimeTreeNodeDao {
    @Insert("INSERT INTO time_tree_node_tbl (userId, time, local, type) VALUES (#{userId}, #{time}, #{local}, 'TTN_LOCAL')")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLocalTimeTreeNode(LocalTimeTreeNode node);

    @Update("UPDATE time_tree_node_tbl SET time = #{time}, local = #{local} WHERE id = #{id} AND userId = #{userId}")
    int updateLocalTimeTreeNode(LocalTimeTreeNode node);

    @Select("SELECT * FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_LOCAL' AND userId = #{userId}")
    LocalTimeTreeNode selectLocalTimeTreeNodeById(@Param("id") long id, @Param("userId") long userId);

    @Delete("DELETE FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_LOCAL' AND userId = #{userId}")
    int deleteLocalTimeTreeNode(@Param("id") long id, @Param("userId") long userId);

    @Select("SELECT * FROM time_tree_node_tbl WHERE type = 'TTN_LOCAL' AND userId = #{userId}")
    List<LocalTimeTreeNode> selectAllLocalTimeTreeNodes(@Param("userId") long userId);
}

