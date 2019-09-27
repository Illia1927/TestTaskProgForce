package com.progForce.testTask.model.factory;

import com.progForce.testTask.model.Market;

public class ProductMarketMaker implements MarketMaker {

    @Override
    public Market createMarket() {
        Market silpo = Market.getMarket("Silpo", 2);
        return silpo;
    }
}
