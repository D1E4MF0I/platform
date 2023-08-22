package com.than.main.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select number from test_tbl where id = 1")
    int testSQL();
}
