package com.pedrohubner.newsservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Properties {
    @Value("${api-key}")
    private String apiKey;

    @Value("${nytimes.api.url}")
    private String nytimesApiUrl;
}
