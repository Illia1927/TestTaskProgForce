package com.progForce.testTask.model;

import java.util.List;

public class Market {
    private Long id;
    private String name;
    private List<Category> categories;

    public Market(String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", categories=" + categories +
                '}';
    }
}
