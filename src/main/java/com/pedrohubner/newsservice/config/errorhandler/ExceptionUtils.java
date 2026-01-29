package com.pedrohubner.newsservice.config.errorhandler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {
    public static GenericException buildException(final int statusCode, final String message) {
        return new GenericException(statusCode, message);
    }
}
