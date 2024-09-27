package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRate;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerWinLossDrawRatio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO
{
    private EntityManager entityManager;

    @Autowired
    public PlayerDAO(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    public List<Player> findAll() {
        //create query
        TypedQuery<Player> theQuery = entityManager.createQuery("from Player", Player.class);

        //execute query
        List<Player> players = theQuery.getResultList();

        //return
        return players;
    }

    public Player findById(int theId) {
        Player thePlayer = entityManager.find(Player.class, theId);

        return thePlayer;
    }

    public Player findByName(String theName) {
        //create query
        TypedQuery<Player> theQuery = entityManager.createQuery("from Player where name='" + theName + "'", Player.class);

        Player thePlayer = theQuery.getResultList().get(0);

        return thePlayer;
    }

    public Player save(Player thePlayer) {
        Player dbPlayer = entityManager.merge(thePlayer);

        return dbPlayer;
    }

    public void deleteById(int theId) {
        Player thePlayer = entityManager.find(Player.class, theId);

        entityManager.remove(thePlayer);
    }

    public List<PlayerWinLossDrawRatio> findAllWinLossDrawRatio() {
        //create query
        TypedQuery<PlayerWinLossDrawRatio> theQuery = entityManager.createQuery("from PlayerWinLossDrawRatio d ORDER BY d.winRatio DESC", PlayerWinLossDrawRatio.class);

        //execute query
        List<PlayerWinLossDrawRatio> playersWLDRatios = theQuery.getResultList();

        //return
        return playersWLDRatios;
    }

    public PlayerWinLossDrawRatio findByIdWinLossDrawRatio(int theId) {
        PlayerWinLossDrawRatio thePlayersWLDRatio = entityManager.find(PlayerWinLossDrawRatio.class, theId);

        return thePlayersWLDRatio;
    }

    public List<PlayerDeckWinRate> findAllPlayerDeckWinRateByPlayerId(int thePlayerId)
    {
        TypedQuery<PlayerDeckWinRate> theQuery = entityManager.createQuery("from PlayerDeckWinRate p where p.playerId=" + thePlayerId + " ORDER BY p.winRate DESC", PlayerDeckWinRate.class);

        List<PlayerDeckWinRate> playerWinRatesByDeck = theQuery.getResultList();

        return playerWinRatesByDeck;
    }
}
