package com.example.demo.controller;

import com.example.demo.client.StashClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseController {

    private final StashClient stashClient;

    @Autowired
    public BaseController(StashClient stashClient) {
        this.stashClient = stashClient;
    }

    @GetMapping("/api/tags")
    public List<String> getTags(){
        List<String> tags = new ArrayList<>();
        tags.add("aaa");
        tags.add("bbb");
        tags.add("ccc");

        return tags;
    }

    @GetMapping("/api/meta")
    public ResponseEntity<String> getMeta(){
        return stashClient.getMeta();
    }

    @GetMapping("/api/posts")
    public ResponseEntity<String> getPosts(){
        return stashClient.getPosts();
    }
}
