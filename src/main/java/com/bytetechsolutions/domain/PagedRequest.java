package com.bytetechsolutions.domain;

public record PagedRequest(int page, int size) {
    
    public static PagedRequest of(int page, int size) {
        return new PagedRequest(page, size);
    }
}
