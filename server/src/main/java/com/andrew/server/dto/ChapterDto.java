package com.andrew.server.dto;

/*
*为何要增加Dto实体类:约定一般domain内的实体不允许改变，是mybatis的-generator生成的不允许修改
* 一旦修改，再次生成实体类时，所做的修改会被覆盖！dto是用于是用于数据传输的，所以会增加和杀出某些属性，
* 从使用范围来说，domain作用于service和mapper;dto作用于controller和service
*
* */

public class ChapterDto {

    private String id;

    private String courseId;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", courseId=" + courseId +
                ", name=" + name +
                "]";
        return sb;
    }
}