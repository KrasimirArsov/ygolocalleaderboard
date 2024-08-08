package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.entity.Duel;

import java.util.List;

public interface DuelService
{
    List<Duel> findAll();

    Duel findById(int theId);

    Duel save(Duel theDuel);

    void deleteById(int theId);
}
