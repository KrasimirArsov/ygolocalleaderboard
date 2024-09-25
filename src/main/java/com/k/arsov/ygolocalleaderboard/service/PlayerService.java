package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.PlayerDAO;
import com.k.arsov.ygolocalleaderboard.entity.DeckWinLossDrawRatio;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.PlayerWinLossDrawRatio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class PlayerService implements CRUDService<Player>
{
    public PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO thePlayerDAO)
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

    public List<PlayerWinLossDrawRatio> findAllPlayerWinLossDrawRatio() {
        return playerDAO.findAllWinLossDrawRatio();
    }

    public PlayerWinLossDrawRatio findByIdIdWinLossDrawRatio(int theId) {
        return playerDAO.findByIdWinLossDrawRatio(theId);
    }

    public List<PlayerWinLossDrawRatio> findTopPlayerWinLossDrawRatio(int numOfTopPlayersWinLossDrawRatios) {
        List<PlayerWinLossDrawRatio> returnList = playerDAO.findAllWinLossDrawRatio();

        return returnList.subList(0, Math.min(numOfTopPlayersWinLossDrawRatios, returnList.size()));
    }
}
