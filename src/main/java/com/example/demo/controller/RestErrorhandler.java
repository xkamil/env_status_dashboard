package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientResponseException;

@ControllerAdvice
public class RestErrorhandler {

    @ExceptionHandler(RestClientResponseException.class)
    public ResponseEntity<String> handleRestClientResponseException(RestClientResponseException ex) {
        final HttpStatus statusCode = HttpStatus.resolve(ex.getRawStatusCode());

        final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        ex.getResponseHeaders().forEach(headers::addAll);

        return new ResponseEntity<>(ex.getResponseBodyAsString(), headers, statusCode);
    }
}
