package com.pedrohubner.newsservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record NewsResponse(
        String status,
        String copyright,
        @JsonProperty("last_updated") String lastUpdated,
        String section,
        @JsonProperty("num_results") int numberOfResults,
        List<ArticleResult> results
) {
}
