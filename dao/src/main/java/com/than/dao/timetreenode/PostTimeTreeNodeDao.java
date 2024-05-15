package com.than.dao.timetreenode;

import com.than.timetree.bean.timetreenode.PostTimeTreeNode;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PostTimeTreeNodeDao {

    @Insert("INSERT INTO time_tree_node_tbl (time, local, type, postId, content, title) VALUES (#{time}, #{local}, 'TTN_POST', #{postId}, #{content}, #{title})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPostTimeTreeNode(PostTimeTreeNode node);

    @Update("UPDATE time_tree_node_tbl SET time = #{time}, local = #{local}, postId = #{postId}, content = #{content}, title = #{title} WHERE id = #{id}")
    int updatePostTimeTreeNode(PostTimeTreeNode node);

    @Select("SELECT * FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_POST'")
    PostTimeTreeNode selectPostTimeTreeNodeById(@Param("id") int id);

    @Delete("DELETE FROM time_tree_node_tbl WHERE id = #{id} AND type = 'TTN_POST'")
    int deletePostTimeTreeNode(@Param("id") int id);
}

