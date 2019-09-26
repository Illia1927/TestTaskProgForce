package com.progForce.testTask.dao.impl;

import com.progForce.testTask.dao.AbstractDao;
import com.progForce.testTask.dao.GoodDao;
import com.progForce.testTask.model.Good;

public class GoodDaoImpl extends AbstractDao<Good, Long> implements GoodDao {
    public GoodDaoImpl(Class<Good> clazz) {
        super(clazz);
    }
}
