package com.pedrohubner.newsservice.service;

import com.pedrohubner.newsservice.config.Properties;
import com.pedrohubner.newsservice.model.NewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class NewsServiceTest {

    @Mock
    private Properties properties;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NewsService newsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetNewsFrom_ValidSection() {
        // Arrange
        String section = "technology";
        String url = "https://api.nytimes.com/svc/topstories/v2";
        String apiKey = "test-api-key";
        NewsResponse mockResponse = mock(NewsResponse.class);

        when(properties.getNyUrl()).thenReturn(url);
        when(properties.getNyApiKey()).thenReturn(apiKey);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(NewsResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        // Act
        NewsResponse response = newsService.getNewsFrom(section);

        // Assert
        assertNotNull(response);
        verify(restTemplate).exchange(contains(section), eq(HttpMethod.GET), any(), eq(NewsResponse.class));
    }

    @Test
    @Disabled
    void testDoRequest_NullUri() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                newsService.doRequest(null, HttpMethod.GET, null, NewsResponse.class));
        assertEquals("URI must not be null", exception.getMessage());
    }

    @Test
    @Disabled
    void testDoRequest_NullMethod() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                newsService.doRequest("https://example.com", null, null, NewsResponse.class));
        assertEquals("HTTP method must not be null", exception.getMessage());
    }

    @Test
    @Disabled
    void testDoRequest_NullResponseType() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                newsService.doRequest("https://example.com", HttpMethod.GET, null, null));
        assertEquals("Response type must not be null", exception.getMessage());
    }
}
