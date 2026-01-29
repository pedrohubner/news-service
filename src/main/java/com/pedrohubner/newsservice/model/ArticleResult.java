package com.pedrohubner.newsservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ArticleResult(
        String section,
        String subsection,
        String title,
        @JsonProperty("abstract") String subtitle,
        String url,
        String uri,
        String byline,
        @JsonProperty("item_type") String type,
        @JsonProperty("updated_date") String dateOfUpdate,
        @JsonProperty("created_date") String creationDate,
        @JsonProperty("published_date") String publicationDate,
        List<Multimedia> multimedia,
        @JsonProperty("short_url") String shortUrl
) {
}
