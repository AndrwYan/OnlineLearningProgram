package com.andrew.server.service;

import com.andrew.server.domain.Chapter;
import com.andrew.server.domain.ChapterExample;
import com.andrew.server.dto.ChapterDto;
import com.andrew.server.dto.PageDto;
import com.andrew.server.mapper.ChapterMapper;
import com.andrew.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;
    /*
    *
    * 分页功能的开发
    *
    **/
    public void list(PageDto pageDto){
        //执行规则：调用startPage方法之后，执行的第一个select语句会进行分页
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        //ctrl+alt+v为表达式生成变量
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtoList = new ArrayList<ChapterDto>();
        for (int i = 0, l=chapterList.size(); i < l; i++) {
            Chapter chapter = chapterList.get(i);
            ChapterDto chapterDto = new ChapterDto();
            //将chapter实体转换为chapterDto
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);
    }

    /*
    *大章新增
    * 注意Dto的转换
    *
    * */
    public void save(ChapterDto chapterDto){
        chapterDto.setId(UuidUtil.getShortUuid());
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterDto,chapter);
        chapterMapper.insert(chapter);
    }
}
