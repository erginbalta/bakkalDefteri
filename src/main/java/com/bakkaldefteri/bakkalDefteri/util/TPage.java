package com.bakkaldefteri.bakkalDefteri.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T> {
    private int number;
    private int size;
    private Sort sort;
    private int totalPage;
    private Long totalElement;
    private List<T> content;

    public void setStat(Page page, List<T> list){
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPage = page.getTotalPages();
        this.totalElement = page.getTotalElements();
        this.content = list;
    }
}

