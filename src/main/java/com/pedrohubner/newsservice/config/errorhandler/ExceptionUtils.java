package com.pedrohubner.newsservice.config.errorhandler;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static GenericException buildException(HttpStatusCode status, String message) {
        return new GenericException(status, message);
    }
}

@Getter
@AllArgsConstructor
class GenericException extends RuntimeException {
    private final HttpStatusCode status;
    private final String message;
}
