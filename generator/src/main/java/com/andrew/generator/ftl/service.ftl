package com.andrew.server.service;

import com.andrew.server.domain.${Domain};
import com.andrew.server.domain.${Domain}Example;
import com.andrew.server.dto.${Domain}Dto;
import com.andrew.server.dto.${Domain}PageDto;
import com.andrew.server.mapper.${Domain}Mapper;
import com.andrew.server.util.CopyUtil;
import com.andrew.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ${Domain}Service {

    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    /**
     * 列表查询
     */
    public void list(${Domain}PageDto ${domain}PageDto) {
        PageHelper.startPage(${domain}PageDto.getPage(), ${domain}PageDto.getSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        ${Domain}Example.Criteria criteria = ${domain}Example.createCriteria();
        if (!StringUtils.isEmpty(${domain}PageDto.getandrewId())) {
            criteria.andandrewIdEqualTo(${domain}PageDto.getandrewId());
        }
        List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}List);
        ${domain}PageDto.setTotal(pageInfo.getTotal());
        List<${Domain}Dto> ${domain}DtoList = CopyUtil.copyList(${domain}List, ${Domain}Dto.class);
        ${domain}PageDto.setList(${domain}DtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(${Domain}Dto ${domain}Dto) {
        ${Domain} ${domain} = CopyUtil.copy(${domain}Dto, ${Domain}.class);
        if (StringUtils.isEmpty(${domain}Dto.getId())) {
            this.insert(${domain});
        } else {
            this.update(${domain});
        }
    }

    /**
     * 新增
     */
    private void insert(${Domain} ${domain}) {
        ${domain}.setId(UuidUtil.getShortUuid());
        ${domain}Mapper.insert(${domain});
    }

    /**
     * 更新
     */
    private void update(${Domain} ${domain}) {
        ${domain}Mapper.updateByPrimaryKey(${domain});
    }

    /**
     * 删除
     */
    public void delete(String id) {
        ${domain}Mapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询某一课程下的所有章
     */
    public List<${Domain}Dto> listByandrew(String andrewId) {
        ${Domain}Example example = new ${Domain}Example();
        example.createCriteria().andandrewIdEqualTo(andrewId);
        List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(example);
        List<${Domain}Dto> ${domain}DtoList = CopyUtil.copyList(${domain}List, ${Domain}Dto.class);
        return ${domain}DtoList;
    }
}
