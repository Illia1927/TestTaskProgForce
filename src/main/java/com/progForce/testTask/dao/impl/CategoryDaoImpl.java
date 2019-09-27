package com.progForce.testTask.dao.impl;

import com.progForce.testTask.dao.AbstractDao;
import com.progForce.testTask.dao.CategoryDao;
import com.progForce.testTask.model.Category;

public class CategoryDaoImpl extends AbstractDao<Category, Long> implements CategoryDao {
    public CategoryDaoImpl(Class<Category> clazz) {
        super(clazz);
    }
}
