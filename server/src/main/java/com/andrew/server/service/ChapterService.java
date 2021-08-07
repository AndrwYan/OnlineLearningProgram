package com.andrew.server.service;

import com.andrew.server.domain.Chapter;
import com.andrew.server.domain.ChapterExample;
import com.andrew.server.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;
    public List<Chapter> list(){
        ChapterExample chapterExample = new ChapterExample();
        //这里演示如何使用ChapterExample
        //ChapterExample就相当于where的条件,可以用orderby
        //chapterExample.createCriteria().andIdEqualTo("1");
        chapterExample.setOrderByClause("id desc");
        return chapterMapper.selectByExample(chapterExample);
    }
}
