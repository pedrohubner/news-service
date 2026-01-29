package com.pedrohubner.newsservice.model;

public record Multimedia(
        String url,
        String format,
        int height,
        int width
) {
}
