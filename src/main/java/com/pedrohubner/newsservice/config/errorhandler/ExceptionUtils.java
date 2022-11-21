package com.pedrohubner.newsservice.config.errorhandler;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static GenericException buildException(HttpStatus status, String message) {
        return new GenericException(status, message);
    }
}

@Getter
@AllArgsConstructor
class GenericException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
