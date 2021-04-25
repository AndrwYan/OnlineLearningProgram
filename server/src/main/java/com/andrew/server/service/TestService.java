package com.andrew.server.service;

import com.andrew.server.domain.Test;
import com.andrew.server.mapper.TestMapper;
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
