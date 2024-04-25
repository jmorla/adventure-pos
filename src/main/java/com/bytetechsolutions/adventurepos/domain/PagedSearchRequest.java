package com.bytetechsolutions.adventurepos.domain;

public record PagedSearchRequest(String search, int page, int size) {
    
    public static PagedSearchRequest of(int page, int size) {
        return new PagedSearchRequest(null, page, size);
    }

    public static PagedSearchRequest of(String search, int page, int size) {
        return new PagedSearchRequest(search, page, size);
    }
}
