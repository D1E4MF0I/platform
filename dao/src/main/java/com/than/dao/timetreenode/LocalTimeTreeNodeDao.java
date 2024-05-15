package com.than.dao.timetreenode;

import com.than.timetree.bean.timetreenode.LocalTimeTreeNode;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LocalTimeTreeNodeDao {

    @Insert("INSERT INTO time_tree_node_tbl (time, local, type) VALUES (#{time}, #{local}, 'TTN_LOCAL')")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLocalTimeTreeNode(LocalTimeTreeNode node);

    @Update("UPDATE time_tree_node_tbl SET time = #{time}, local = #{local} WHERE id = #{id}")
    int updateLocalTimeTreeNode(LocalTimeTreeNode node);

    @Select("SELECT * FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_LOCAL'")
    LocalTimeTreeNode selectLocalTimeTreeNodeById(@Param("id") int id);

    @Delete("DELETE FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_LOCAL'")
    int deleteLocalTimeTreeNode(@Param("id") int id);
}

