package com.pedrohubner.newsservice.controller;

import com.pedrohubner.newsservice.config.Properties;
import com.pedrohubner.newsservice.model.NewsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class NewsController {

    private final Properties properties;
    private final RestTemplate restTemplate;

    @GetMapping
    public NewsResponse getNewsFrom(@RequestParam("section") String section) {
        final var formattedUri = String.format(properties.getNytimesApiUrl(), section, properties.getApiKey());
        return doRequest(formattedUri, HttpMethod.GET, null, NewsResponse.class);
    }

    public <T> T doRequest(String uri, HttpMethod method, Object body, Class<T> responseType) {
        final var request = new HttpEntity<>(body);
        return restTemplate.exchange(uri, method, request, responseType).getBody();
    }
}
