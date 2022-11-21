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
        return response.getStatusCode().series().equals(HttpStatus.Series.CLIENT_ERROR)
                || response.getStatusCode().series().equals(HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw ExceptionUtils.buildException(response.getStatusCode(), response.getStatusText());
    }
}
