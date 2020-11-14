package com.click.house.service.impl;

import com.click.house.entity.Test;
import com.click.house.entity.UserInfo;
import com.click.house.mapper.TestMapper;
import com.click.house.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public void save(Test test) {
        testMapper.save(test);
    }

    @Override
    public Test selectById(Integer pointId) {
        return testMapper.selectById(pointId);
    }

    @Override
    public List<Test> select() {
        return testMapper.select();
    }

    @Override
    public void batchInsert(List<Test> list) {
        testMapper.batchInsert(list);
    }
}
