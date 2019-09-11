package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
class GitHubResponse<T> {
    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    private List<T> items;
}
