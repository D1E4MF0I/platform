package com.than.dao.timetreenode;

import com.than.timetree.bean.timetreenode.LocalTimeTreeNode;
import com.than.timetree.bean.timetreenode.OperateTimeTreeNode;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OperateTimeTreeNodeDao {
    @Insert("INSERT INTO time_tree_node_tbl (userId, time, local, type, operate) VALUES (#{userId}, #{time}, #{local}, 'TTN_OPERATE', #{operate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOperateTimeTreeNode(OperateTimeTreeNode node);

    @Update("UPDATE time_tree_node_tbl SET time = #{time}, local = #{local}, operate = #{operate} WHERE id = #{id} AND userId = #{userId}")
    int updateOperateTimeTreeNode(OperateTimeTreeNode node);

    @Select("SELECT * FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_OPERATE' AND userId = #{userId}")
    OperateTimeTreeNode selectOperateTimeTreeNodeById(@Param("id") long id, @Param("userId") long userId);

    @Delete("DELETE FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_OPERATE' AND userId = #{userId}")
    int deleteOperateTimeTreeNode(@Param("id") long id, @Param("userId") long userId);



    @Select("SELECT id, userId, time, local, type, operate FROM time_tree_node_tbl WHERE type = 'TTN_OPERATE' AND userId = #{userId}")
    @Results(value = {
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(property = "userId", column = "userId", javaType = Long.class),
            @Result(property = "time", column = "time", javaType = Timestamp.class),
            @Result(property = "local", column = "local", javaType = String.class),
            @Result(property = "type", column = "type", javaType = String.class),
            @Result(property = "operate", column = "operate", javaType = String.class)
    })
    List<OperateTimeTreeNode> selectAllOperateTimeTreeNodes(@Param("userId") long userId);

}

