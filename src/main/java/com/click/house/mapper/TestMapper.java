package com.click.house.mapper;

import com.click.house.entity.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangxg
 * @version 2020/11/7
 */
public interface TestMapper {
    void save(Test test);
    Test selectById(@Param("pointId") Integer pointId) ;
    List<Test> select() ;
    void batchInsert(@Param("list") List<Test> list);
}
