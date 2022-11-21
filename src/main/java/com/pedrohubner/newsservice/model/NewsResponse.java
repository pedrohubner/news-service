package com.pedrohubner.newsservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NewsResponse {
    private String status;
    private String copyright;
    @JsonProperty(value = "last_updated")
    private String lastUpdated;
    private String section;
    @JsonProperty(value = "num_results")
    private int numberOfResults;
    private List<ArticleResult> results;
}

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class ArticleResult {
    private String section;
    private String subsection;
    private String title;
    @JsonProperty(value = "abstract")
    private String subtitle;
    private String url;
    private String uri;
    private String byline;
    @JsonProperty(value = "item_type")
    private String type;
    @JsonProperty(value = "updated_date")
    private String dateOfUpdate;
    @JsonProperty(value = "created_date")
    private String creationDate;
    @JsonProperty(value = "published_date")
    private String publicationDate;
    private List<Multimedia> multimedia;
    @JsonProperty(value = "short_url")
    private String shortUrl;
}

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class Multimedia {
    private String url;
    private String format;
    private int height;
    private int width;
    private String type;
    private String subtype;
    private String caption;
    private String copyright;
}
