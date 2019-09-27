package com.progForce.testTask.service.impl;

import com.progForce.testTask.dao.CategoryDao;
import com.progForce.testTask.dao.impl.CategoryDaoImpl;
import com.progForce.testTask.model.Category;
import com.progForce.testTask.service.CategoryService;

import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = new CategoryDaoImpl(Category.class);

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryDao.readById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void removeCategory(Long id) {
        categoryDao.deleteById(id);
    }
}
