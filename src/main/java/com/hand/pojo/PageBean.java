package com.hand.pojo;

import java.util.List;

/**
 * Created by 铭刻 on 2017/8/15.
 */
public class PageBean {
    private List<Film> list;
    private int firstPage =1;
    private int prePage;
    private int nextPage;
    private int totalPage;
    private int currentPage;
    private int totalCount;
    private int pageSize;
    private int startNum;


    public int getStartNum() {
        return (this.getCurrentPage()-1)*pageSize;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }


    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public List<Film> getList() {
        return list;
    }

    public void setList(List<Film> list) {
        this.list = list;
    }

    //计算出总页数。
    public int getTotalPage() {
        return (this.getTotalCount()%this.getPageSize()==0)?
                (this.getTotalCount()/this.getPageSize()):
                (this.getTotalCount()/this.getPageSize()+1);
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return this.getCurrentPage()==1?1:this.getCurrentPage()-1;
    }
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
    public int getNextPage() {
        return this.getCurrentPage()==this.getTotalPage()?this.getTotalPage():this.getCurrentPage()+1;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", firstPage=" + firstPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", startNum=" + startNum +
                '}';
    }
}
