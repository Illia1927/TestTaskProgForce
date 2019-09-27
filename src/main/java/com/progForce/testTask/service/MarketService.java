package com.progForce.testTask.service;

import com.progForce.testTask.model.Market;

import java.util.Optional;

public interface MarketService {
    void addMarket(Market market);

    Optional<Market> getMarketById(Long id);

    void updateMarket(Market market);

    void removeMarket(Long id);
}
