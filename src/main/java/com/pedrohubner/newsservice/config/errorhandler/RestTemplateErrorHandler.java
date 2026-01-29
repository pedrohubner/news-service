package com.pedrohubner.newsservice.config.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        final var statusCode = response.getStatusCode();
        return statusCode.is4xxClientError() || statusCode.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        final var statusCode = response.getStatusCode();
        final var statusText = response.getStatusText();

        if (statusCode.value() == HttpStatus.UNAUTHORIZED.value()) {
            throw new GenericException(401, "Unauthorized: Please check your API key.");
        }

        throw ExceptionUtils.buildException(statusCode.value(), statusText);
    }
}
