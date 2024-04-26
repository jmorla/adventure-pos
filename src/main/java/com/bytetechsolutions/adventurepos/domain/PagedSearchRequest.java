package com.bytetechsolutions.adventurepos.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagedSearchRequest {

    private String query;
    private int page;
    private int size;

    @JsonCreator
    public PagedSearchRequest(
            @JsonProperty("query") String query,
            @JsonProperty("page") int page,
            @JsonProperty("size") int size) {
        this.query = query;
        this.page = page;
        this.size = size;
    }

    public static PagedSearchRequest of(int page, int size) {
        return new PagedSearchRequest(null, page, size);
    }

    public static PagedSearchRequest of(String search, int page, int size) {
        return new PagedSearchRequest(search, page, size);
    }
}
