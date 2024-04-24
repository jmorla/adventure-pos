package com.bytetechsolutions.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Value;

@Value
public class PagedResponse<T> {

    List<T> content;

    long totalPages;

    long totalElements;

    long currentPage;

    long numberOfElements;

    boolean last;

    private PagedResponse(List<T> content,
            long totalPages,
            long totalElements,
            long currentPage,
            long numberOfElements,
            boolean last) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.numberOfElements = numberOfElements;
        this.last = last;
    }

    public static <T> PagedResponse<T> from(Page<T> page) {
        return new PagedResponse<T>(
                page.getContent(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getPageable().getPageNumber(),
                page.getNumberOfElements(),
                page.isLast());
    }
}
