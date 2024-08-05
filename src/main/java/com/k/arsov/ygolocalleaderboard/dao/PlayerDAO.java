package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.Player;

import java.util.List;

public interface PlayerDAO {
    List<Player> findAll();

    Player findById(int theId);

    Player save(Player thePlayer);

    void deleteById(int theId);
}