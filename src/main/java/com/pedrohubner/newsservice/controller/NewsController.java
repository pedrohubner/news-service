package com.pedrohubner.newsservice.controller;

import com.pedrohubner.newsservice.model.NewsResponse;
import com.pedrohubner.newsservice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/ny-times")
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public NewsResponse getNewsFrom(@RequestParam("section") String section) {
        return this.newsService.getNewsFrom(section);
    }
}
