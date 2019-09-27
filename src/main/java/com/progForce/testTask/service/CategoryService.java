package com.progForce.testTask.service;

import com.progForce.testTask.model.Category;

import java.util.Optional;

public interface CategoryService {
    void addCategory(Category category);

    Optional<Category> getCategoryById(Long id);

    void updateCategory(Category category);

    void removeCategory(Long id);
}
