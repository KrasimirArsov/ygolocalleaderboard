package com.k.arsov.ygolocalleaderboard.service;

import java.util.List;

public interface Service <T>
{
    List<T> findAll();

    T findById(int theId);

    T save(T theDeck);

    void deleteById(int theId);
}
