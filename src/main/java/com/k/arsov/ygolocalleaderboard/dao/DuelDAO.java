package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Duel;

import java.util.List;

public interface DuelDAO {
    List<Duel> findAll();

    Duel findById(int theId);

    Duel save(Duel theDuel);

    void deleteById(int theId);
}