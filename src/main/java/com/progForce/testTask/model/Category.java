package com.progForce.testTask.model;

public class Category {
    private Integer id;
    private String name;
    private Integer goodId;

    public Category() {
    }

    public Category(String name, Integer goodId) {
        this.name = name;
        this.goodId = goodId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGood() {
        return goodId;
    }

    public void setGood(Integer good) {
        this.goodId = good;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", goodsId=" + goodId +
                '}';
    }
}
