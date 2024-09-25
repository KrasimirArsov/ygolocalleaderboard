package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Duel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DuelDAO
{
    private EntityManager entityManager;

    @Autowired
    public DuelDAO(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    public List<Duel> findAll() {
        //create query
        TypedQuery<Duel> theQuery = entityManager.createQuery("from Duel d ORDER BY d.duelDate DESC", Duel.class);

        //execute query
        List<Duel> duels = theQuery.getResultList();

        //return
        return duels;
    }

    public Duel findById(int theId) {
        Duel theDuel = entityManager.find(Duel.class, theId);

        return theDuel;
    }

    public Duel save(Duel theDuel) {
        Duel dbDuel = entityManager.merge(theDuel);

        return dbDuel;
    }

    public void deleteById(int theId) {
        Duel theDuel = entityManager.find(Duel.class, theId);

        entityManager.remove(theDuel);
    }
}
