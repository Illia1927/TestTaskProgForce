package com.progForce.testTask.model;

import java.util.List;

public class Category {
    private Long id;
    private String name;
    private List<Good> goods;

    public Category(String name, List<Good> goods) {
        this.name = name;
        this.goods = goods;
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

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
