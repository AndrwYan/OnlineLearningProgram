package com.andrew.business.controller.admin;

import com.andrew.server.dto.ChapterDto;
import com.andrew.server.dto.PageDto;
import com.andrew.server.dto.ResponseDto;
import com.andrew.server.service.ChapterService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public ResponseDto<Object> list(@RequestBody PageDto pageDto){
        ResponseDto<Object> responseDto = new ResponseDto<>();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /*
    * 大章新增方法
    *
    * */
    @RequestMapping("/save")
    public ResponseDto save( @RequestBody ChapterDto chapterDto){
        ResponseDto<Object> responseDto = new ResponseDto<>();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }
}
