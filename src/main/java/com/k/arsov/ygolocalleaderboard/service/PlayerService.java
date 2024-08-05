package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.entity.Player;

import java.util.List;

public interface PlayerService
{
    List<Player> findAll();

    Player findById(int theId);

    Player save(Player thePlayer);

    void deleteById(int theId);
}
