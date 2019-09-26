package com.progForce.testTask.dao;

import com.progForce.testTask.model.Good;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T, ID> {

    T save(T entity);

    Optional<Good> deleteById(ID id);

    T readById(ID id);

    void update(T entity);

    List<T> getAll();
}
