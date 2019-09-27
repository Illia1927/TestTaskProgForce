package com.progForce.testTask;

import com.progForce.testTask.model.Category;
import com.progForce.testTask.model.Good;
import com.progForce.testTask.model.factory.GoodsMarketMaker;
import com.progForce.testTask.model.factory.MarketMaker;
import com.progForce.testTask.model.factory.ProductMarketMaker;
import com.progForce.testTask.service.CategoryService;
import com.progForce.testTask.service.GoodService;
import com.progForce.testTask.service.impl.CategoryServiceImpl;
import com.progForce.testTask.service.impl.GoodServiceImpl;

public class Main {
    public static void main(String[] args) {
        GoodService goodService = new GoodServiceImpl();
        Good goodFruits = new Good();
        goodFruits.setTitle("Apple");
        goodFruits.setPrice(20D);
        goodFruits.setStatus("AVAILABLE");
        goodService.addGood(goodFruits);

        Category categoryForProduct = new Category();
        categoryForProduct.setName("Fruits");
        categoryForProduct.setGood(1);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.addCategory(categoryForProduct);

        Thread threadFirst = new Thread(new FirstSingletonThread());
        Thread threadSecond = new Thread(new SecondSingletonThread());
        threadFirst.start();
        threadSecond.start();
    }
    static class FirstSingletonThread implements Runnable {
        @Override
        public void run() {
            MarketMaker silpo = new ProductMarketMaker();
            silpo.createMarket();
        }
    }
    static class SecondSingletonThread implements Runnable {
        @Override
        public void run() {
            MarketMaker epicentr = new GoodsMarketMaker();
            epicentr.createMarket();
        }
    }
}
