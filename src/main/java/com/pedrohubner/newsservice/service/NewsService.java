package com.pedrohubner.newsservice.service;

import com.pedrohubner.newsservice.config.Properties;
import com.pedrohubner.newsservice.model.NewsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class NewsService {

    private final Properties properties;
    private final RestTemplate restTemplate;

    public NewsResponse getNewsFrom(String section) {
        final var formattedUri = String.format(
                "%s/%s.json?api-key=%s", properties.getNyUrl(), section, properties.getNyApiKey()
        );
        return doRequest(formattedUri, HttpMethod.GET, null, NewsResponse.class);
    }

    public <T> T doRequest(String uri, HttpMethod method, Object body, Class<T> responseType) {
        final var request = new HttpEntity<>(body);
        return restTemplate.exchange(uri, method, request, responseType).getBody();
    }
}
