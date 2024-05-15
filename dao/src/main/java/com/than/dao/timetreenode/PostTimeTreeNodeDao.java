package com.than.dao.timetreenode;

import com.than.timetree.bean.timetreenode.LocalTimeTreeNode;
import com.than.timetree.bean.timetreenode.PostTimeTreeNode;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PostTimeTreeNodeDao {
    @Insert("INSERT INTO time_tree_node_tbl (userId, time, local, type, postId, content, title) VALUES (#{userId}, #{time}, #{local}, 'TTN_POST', #{postId}, #{content}, #{title})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPostTimeTreeNode(PostTimeTreeNode node);

    @Update("UPDATE time_tree_node_tbl SET time = #{time}, local = #{local}, postId = #{postId}, content = #{content}, title = #{title} WHERE id = #{id} AND userId = #{userId}")
    int updatePostTimeTreeNode(PostTimeTreeNode node);

    @Select("SELECT * FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_POST' AND userId = #{userId}")
    PostTimeTreeNode selectPostTimeTreeNodeById(@Param("id") long id, @Param("userId") long userId);

    @Delete("DELETE FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_POST' AND userId = #{userId}")
    int deletePostTimeTreeNode(@Param("id") long id, @Param("userId") long userId);

    @Select("SELECT id, userId, time, local, type, postId, content, title FROM time_tree_node_tbl WHERE userId = #{userId} AND type = 'TTN_POST'")
    @Results(value = {
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(property = "userId", column = "userId", javaType = Long.class),
            @Result(property = "time", column = "time", javaType = Timestamp.class),
            @Result(property = "local", column = "local", javaType = String.class),
            @Result(property = "type", column = "type", javaType = String.class),
            @Result(property = "postId", column = "postId", javaType = Long.class),
            @Result(property = "content", column = "content", javaType = String.class),
            @Result(property = "title", column = "title", javaType = String.class)
    })
    List<PostTimeTreeNode> selectAllPostTimeTreeNodes(@Param("userId") long userId);
}

