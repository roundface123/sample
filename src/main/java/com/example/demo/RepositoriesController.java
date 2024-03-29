package com.example.demo;


import com.example.demo.dto.GitHubRepositoriesResponse;
import com.example.demo.dto.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RepositoriesController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ping")
    public String ping() {
        return "ping success";
    }

    @RequestMapping("/api/repositories")
    public List<Repository> repositories(@RequestParam(name = "q") String query) {
        ResponseEntity<GitHubRepositoriesResponse> forEntity =
                restTemplate.getForEntity(String.format("https://api.github.com/search/repositories?q=%s", query), GitHubRepositoriesResponse.class);
        return forEntity.getBody().getItems();
    }
}
