package com.progForce.testTask.dao.impl;

import com.progForce.testTask.dao.AbstractDao;
import com.progForce.testTask.dao.MarketDao;
import com.progForce.testTask.model.Market;

public class MarketDaoImpl extends AbstractDao<Market, Long> implements MarketDao {
    public MarketDaoImpl(Class<Market> clazz) {
        super(clazz);
    }
}
