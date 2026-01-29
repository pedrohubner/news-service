package com.pedrohubner.newsservice.config.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenericException extends RuntimeException {
    private final int statusCode;
    private final String message;
}
