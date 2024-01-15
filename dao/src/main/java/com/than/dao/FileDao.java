package com.than.dao;

import com.than.controller.bean.FileBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Than
 * @package: com.than.dao
 * @className: FileDao
 * @description: 文件记录及删除
 * @date: 2023/10/15 20:52
 */
@Mapper
public interface FileDao {
    // 插入操作
    @Insert("INSERT INTO file_tbl(url, path, time) VALUES(#{url}, #{path}, #{time})")
    boolean insert(FileBean file);

    // 删除操作
    @Delete("DELETE FROM file_tbl WHERE id = #{id}")
    boolean deleteById(int id);

    // 更新操作
    @Update("UPDATE file_tbl SET url = #{url}, path = #{path}, time = #{time} WHERE id = #{id}")
    boolean update(FileBean file);

    // 根据ID查询操作
    @Select("SELECT * FROM file_tbl WHERE id = #{id}")
    FileBean selectById(int id);

    // 查询所有记录
    @Select("SELECT * FROM file_tbl")
    List<FileBean> selectAll();
}
