package com.than;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select  * from content")
    @Result(column = "deptid", property = "userId")
    public List<Content> findAll();

}
