package com.progForce.testTask.service;

import com.progForce.testTask.model.Good;

import java.util.Optional;

public interface GoodService {
    void addGood(Good good);

    Optional<Good> getGoodById(Long id);

    void updateGood(Good good);

    void removeGood(Long id);
}
