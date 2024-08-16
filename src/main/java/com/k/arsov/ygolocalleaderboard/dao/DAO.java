package com.k.arsov.ygolocalleaderboard.dao;

import java.util.List;

public interface DAO <T>
{
    List<T> findAll();

    T findById(int theId);

    T save(T theEntity);

    void deleteById(int theId);
}
