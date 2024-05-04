package com.bytetechsolutions.adventurepos.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {

    private final String name;
    private final String description;

    @JsonCreator
    public CategoryRequest(@JsonProperty("name") String name,
            @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CategoryRequest [name=" + name + ", description=" + description + "]";
    }

}
