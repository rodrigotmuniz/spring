/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author rodrigo.muniz
 * @param <T>
 */
public class PageableResponse<T>{
    private List<T> content;
    @JsonProperty("number")
    private int page;
    private int totalElements;
    
    
    public PageableResponse() {
    }

//    public PageableResponse(@JsonProperty("content") List<T> content, @JsonProperty("number") int page, @JsonProperty("totalElements") int totalElements) {
//        this.content = content;
//        this.page = page;
//        this.totalElements = totalElements;
//    }
    
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalElements() {
        return totalElements;
    }
}
