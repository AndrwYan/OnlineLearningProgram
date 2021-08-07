package com.andrew.business.controller;

import com.andrew.server.domain.Chapter;
import com.andrew.server.service.ChapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class ChapterController {
    
    @Resource
    private ChapterService chapterService;

    @GetMapping("/chapter")
    public List<Chapter> chapter(){
        return chapterService.list();
    }
}
