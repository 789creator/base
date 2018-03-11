package com.base.api.common.page;


import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
/**
 * Created by hqm on 2017/5/17.
 * 分页包装对象
 */
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = -4068430693984766027L;

    private List<T> result;

    private PageInfo page;

    public PageQuery(List<T> result, PageInfo page) {
        this.result = result;
        this.page = page;
    }

    public PageQuery<T> page(PageInfo value) {
        this.page = value;
        return this;
    }

    public PageQuery() {
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        if (result == null) {
            this.result = Collections.emptyList();
        } else {
            this.result = result;
        }
    }

    public PageQuery<T> result(List<T> result) {
        if (result == null) {
            this.result = Collections.emptyList();
        } else {
            this.result = result;
        }
        return this;
    }
}