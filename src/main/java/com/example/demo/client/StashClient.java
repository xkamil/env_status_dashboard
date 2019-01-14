package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class StashClient {

    private static final Logger logger = LoggerFactory.getLogger(StashClient.class);
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${stash.url}")
    private String baseUrl;

    @Value("${stash.credentials.username}")
    private String username;

    @Value("${stash.credentials.password}")
    private String password;

    @Autowired
    public StashClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ResponseEntity<String> getMeta() {
        return restTemplateBuilder.rootUri(baseUrl)
                .basicAuthentication(username, password)
                .build()
                .getForEntity("/api/meta2", String.class);
    }

    public ResponseEntity<String> getPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return restTemplateBuilder.build().getForEntity(url, String.class);
    }
}
