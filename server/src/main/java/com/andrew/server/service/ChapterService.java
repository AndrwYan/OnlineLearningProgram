package com.andrew.server.service;

import com.andrew.server.domain.Chapter;
import com.andrew.server.domain.ChapterExample;
import com.andrew.server.dto.ChapterDto;
import com.andrew.server.mapper.ChapterMapper;
import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    public List<ChapterDto> list(){
        //执行规则：调用startPage方法之后，执行的第一个select语句会进行分页
        PageHelper.startPage(1,1);
        ChapterExample chapterExample = new ChapterExample();
//        chapterExample.createCriteria().andCourseIdEqualTo("1");
//        chapterExample.setOrderByClause("id desc");
        //ctrl+alt+v为表达式生成变量
        List<ChapterDto> chapterDtoList = new ArrayList<ChapterDto>();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        for (int i = 0, l=chapterList.size(); i < l; i++) {
            ChapterDto chapterDto = new ChapterDto();
            Chapter chapter = chapterList.get(i);
            //将chapter实体转换为chapterDto
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        return chapterDtoList;
    }
}
