package com.progForce.testTask.service.impl;

import com.progForce.testTask.dao.MarketDao;
import com.progForce.testTask.dao.impl.MarketDaoImpl;
import com.progForce.testTask.model.Market;
import com.progForce.testTask.service.MarketService;

import java.util.Optional;

public class MarketServiceImpl implements MarketService {

    private final MarketDao marketDao = new MarketDaoImpl(Market.class);

    @Override
    public void addMarket(Market market) {
        marketDao.save(market);
    }

    @Override
    public Optional<Market> getMarketById(Long id) {
        return marketDao.readById(id);
    }

    @Override
    public void updateMarket(Market market) {
        marketDao.update(market);
    }

    @Override
    public void removeMarket(Long id) {
        marketDao.deleteById(id);
    }
}
