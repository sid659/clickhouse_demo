package com.click.house.service;

import com.click.house.entity.Test;

import java.util.List;

public interface TestService {
    void save(Test test);
    Test selectById(Integer id);
    List<Test> select();
    void batchInsert(List<Test> list);
}
