package com.lessons.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchDTO {
    private List <String> filters;

    @JsonProperty("raw_query")
    private String rawQuery;

    public String getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(String rawQuery) {
        this.rawQuery = rawQuery;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }
}
