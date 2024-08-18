package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DAO;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class PlayerServiceImpl implements CRUDService<Player>
{
    public DAO<Player> playerDAO;

    @Autowired
    public PlayerServiceImpl(DAO<Player> thePlayerDAO)
    {
        playerDAO = thePlayerDAO;
    }

    @Override
    public List<Player> findAll() {
        return playerDAO.findAll();
    }

    @Override
    public Player findById(int theId) {
        return playerDAO.findById(theId);
    }

    @Transactional
    @Override
    public Player save(Player thePlayer) {
        return playerDAO.save(thePlayer);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        playerDAO.deleteById(theId);
    }
}
