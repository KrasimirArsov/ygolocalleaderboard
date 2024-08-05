package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DeckDAO;
import com.k.arsov.ygolocalleaderboard.dao.PlayerDAO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class PlayerServiceImpl implements PlayerService
{
    public PlayerDAO PlayerDAO;

    @Autowired
    public PlayerServiceImpl(PlayerDAO thePlayerDAO)
    {
        PlayerDAO = thePlayerDAO;
    }

    @Override
    public List<Player> findAll() {
        return PlayerDAO.findAll();
    }

    @Override
    public Player findById(int theId) {
        return PlayerDAO.findById(theId);
    }

    @Transactional
    @Override
    public Player save(Player thePlayer) {
        return PlayerDAO.save(thePlayer);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        PlayerDAO.deleteById(theId);
    }
}
