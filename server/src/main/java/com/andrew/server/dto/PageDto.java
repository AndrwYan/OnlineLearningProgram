package com.andrew.server.dto;

import java.util.List;

/*
*
* PageDto:前后端交互用到的类，包含前端传进来的属性和后端查询所得结果
* 通用类
* 前端传入参数，后端处理之后再次塞进去参数，最后返回参数
*
* */


public class PageDto<T> {
    /*
    * 当前页码
    *t
    * */
    protected int page;

    /*
    *
    每页条数
    *
    * */
    protected int size;
    /*
     * 总条数
     *
     * */
    protected long total;

    /*
    *
    *使用泛型的地方都可以用object，但是泛型在编译器就会发现问题，并且避免了代码中写强制类型转换
    *
    * */
    protected List<T> list;

    public PageDto(int page, int size, long total, List<T> list) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getList() {
        return list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "page=" + page +
                ", size=" + size +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
