package com.andrew.business.controller.admin;

import com.andrew.server.dto.${Domain}Dto;
import com.andrew.server.dto.${Domain}PageDto;
import com.andrew.server.dto.ResponseDto;
import com.andrew.server.service.${Domain}Service;
import com.andrew.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);
    public static final String BUSINESS_NAME = "大章";

    @Resource
    private ${Domain}Service ${domain}Service;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody ${Domain}PageDto ${domain}PageDto) {
        ResponseDto responseDto = new ResponseDto();
        ValidatorUtil.require(${domain}PageDto.getCourseId(), "课程ID");
        ${domain}Service.list(${domain}PageDto);
        responseDto.setContent(${domain}PageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto) {
        //保存校验要和具体的字段有关，在生成的时候，先把它给删除掉
        // 保存校验
        //


        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.delete(id);
        return responseDto;
    }
}
