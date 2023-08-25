package com.than.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select number from test_tbl where id = 1")
    int testSQL();
}
