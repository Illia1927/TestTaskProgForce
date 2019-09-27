package com.progForce.testTask.model.factory;

import com.progForce.testTask.model.Market;

public class GoodsMarketMaker implements MarketMaker {
    @Override
    public Market createMarket() {
        Market epicentr = new Market("Epicentr", 2);
        return epicentr;
    }
}
