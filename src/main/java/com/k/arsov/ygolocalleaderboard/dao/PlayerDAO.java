package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO implements DAO<Player>
{
    private EntityManager entityManager;

    @Autowired
    public PlayerDAO(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    @Override
    public List<Player> findAll() {
        //create query
        TypedQuery<Player> theQuery = entityManager.createQuery("from Player", Player.class);

        //execute query
        List<Player> players = theQuery.getResultList();

        //return
        return players;
    }

    @Override
    public Player findById(int theId) {
        Player thePlayer = entityManager.find(Player.class, theId);

        return thePlayer;
    }

    @Override
    public Player save(Player thePlayer) {
        Player dbPlayer = entityManager.merge(thePlayer);

        return dbPlayer;
    }

    @Override
    public void deleteById(int theId) {
        Player thePlayer = entityManager.find(Player.class, theId);

        entityManager.remove(thePlayer);
    }
}
