package com.progForce.testTask.model;

public class Good {
    private Long id;
    private String title;
    private Double price;
    private Enum status;

    public Good(String title, Double price, Enum status) {
        this.title = title;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public enum STATUS{
        AVAILABLE,
        ABSENT,
        EXPECTED
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
