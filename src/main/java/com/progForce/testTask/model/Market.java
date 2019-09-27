package com.progForce.testTask.model;

public class Market {
    private static volatile Market market = new Market();
    private Integer id;
    private String name;
    private Integer categoryId;

    public Market() {
    }

    public Market(String name, Integer categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public static synchronized Market getMarket(String name, Integer categoryId) {
        if (market == null) {
            synchronized (Market.class) {
                if (market == null) {
                    market = new Market(name, categoryId);
                }
            }
        }
        return market;
    }

    public static void setMarket(Market market) {
        Market.market = market;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
