package com.base.api.common.page;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by hqm on 2017/5/17.
 * 分页对象
 */
public class Page implements Serializable{

    private static final Integer DEFUALT_PAGE_SIZE = 30;

    private static final Integer DEFAULT_TOTAL_NUM = 0;
    /**
     * 分页中，页面大小，即每页显示多少的数据
     */
    @JsonProperty("page_size")
    private Integer pageSize = DEFUALT_PAGE_SIZE;

    @JsonProperty("page")
    private Integer currentPage = 1;

    @JsonProperty("total_num")
    private Integer totalNum = DEFAULT_TOTAL_NUM;


    @JsonIgnore
    private Integer startIndex;

    @JsonIgnore
    private Integer endIndex;

    private Integer totalPage;

    @JsonProperty("sort_type")
    private Integer sortType=0;

    public Page(Integer pageSize, Integer currentPage) {
        this.pageSize = pageSize;
        setCurrentPage(currentPage);
    }

    public Page(Integer pageSize, Integer currentPage, Integer totalNum) {
        super();
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalNum = totalNum;
    }

    public Page() {
        setPageSize(DEFUALT_PAGE_SIZE);
    }

    @JsonIgnore
    public Integer getTotalPageNum() {
        if (totalNum == 0) {
            return Integer.valueOf(0);
        }
        return totalNum / pageSize + (totalNum % pageSize == 0 ? 0 : 1);
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = DEFUALT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
        caculatIndex();
    }

    /**
     * @return the currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null) {
            this.currentPage = Integer.valueOf(1);
        } else {
            this.currentPage = currentPage;
        }
        caculatIndex();
    }

    /**
     * @return the totalNum
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * @param totalNum the totalNum to set
     */
    public void setTotalNum(Integer totalNum) {
        if (totalNum == null) {
            this.totalNum = DEFAULT_TOTAL_NUM;
            return;
        }
        this.totalNum = totalNum;
    }

    private void caculatIndex() {
        if (this.currentPage == null || this.currentPage <= 1) {
            this.currentPage = 1;
        }
        if (this.pageSize == null || this.pageSize <= 0) {
            this.pageSize = DEFUALT_PAGE_SIZE;
        }
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.endIndex = this.pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    @JsonProperty("total_page")
    public Integer getTotalPage() {
        return (int)Math.ceil((double)this.getTotalNum() / this.getPageSize());
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return "c:"+currentPage+"s:"+pageSize+"t:"+totalNum;
    }

    public Integer getTotalCount() {
        return totalNum;
    }
}
