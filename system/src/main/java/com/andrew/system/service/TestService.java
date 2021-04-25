package com.andrew.system.service;

import com.andrew.system.domain.Test;
import com.andrew.system.mapper.TestMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
