package com.progForce.testTask.service.impl;

import com.progForce.testTask.dao.GoodDao;
import com.progForce.testTask.dao.impl.GoodDaoImpl;
import com.progForce.testTask.model.Good;
import com.progForce.testTask.service.GoodService;

import java.util.Optional;

public class GoodServiceImpl implements GoodService {

    private final GoodDao goodDao = new GoodDaoImpl(Good.class);

    @Override
    public void addGood(Good good) {
        goodDao.save(good);
    }

    @Override
    public Optional<Good> getGoodById(Long id) {
        return goodDao.readById(id);
    }

    @Override
    public void updateGood(Good good) {
        goodDao.update(good);
    }

    @Override
    public void removeGood(Long id) {
        goodDao.deleteById(id);
    }
}
