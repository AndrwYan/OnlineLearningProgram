package com.andrew.server.service;

import com.andrew.server.domain.Test;
import com.andrew.server.domain.TestExample;
import com.andrew.server.mapper.TestMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;



@Service
public class TestService {
    @Resource
    private TestMapper testMapper;
    public List<Test> list(){
        TestExample testExample = new TestExample();
        //这里演示如何使用TestExample
        //TestExample就相当于where的条件,可以用orderby
        //testExample.createCriteria().andIdEqualTo("1");
        testExample.setOrderByClause("id desc");
        return testMapper.selectByExample(testExample);
    }
}
