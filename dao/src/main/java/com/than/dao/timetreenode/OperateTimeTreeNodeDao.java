package com.than.dao.timetreenode;

import com.than.timetree.bean.timetreenode.OperateTimeTreeNode;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OperateTimeTreeNodeDao {

    @Insert("INSERT INTO time_tree_node_tbl (time, local, type, operate) VALUES (#{time}, #{local}, 'TTN_OPERATE', #{operate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOperateTimeTreeNode(OperateTimeTreeNode node);

    @Update("UPDATE time_tree_node_tbl SET time = #{time}, local = #{local}, operate = #{operate} WHERE id = #{id}")
    int updateOperateTimeTreeNode(OperateTimeTreeNode node);

    @Select("SELECT * FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_OPERATE'")
    OperateTimeTreeNode selectOperateTimeTreeNodeById(@Param("id") int id);

    @Delete("DELETE FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_OPERATE'")
    int deleteOperateTimeTreeNode(@Param("id") int id);
}

