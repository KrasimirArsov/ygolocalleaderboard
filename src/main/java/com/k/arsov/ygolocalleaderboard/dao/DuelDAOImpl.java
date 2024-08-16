package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Duel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DuelDAOImpl implements DAO<Duel>
{
    private EntityManager entityManager;

    @Autowired
    public DuelDAOImpl(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    @Override
    public List<Duel> findAll() {
        //create query
        TypedQuery<Duel> theQuery = entityManager.createQuery("from Duel", Duel.class);

        //execute query
        List<Duel> duels = theQuery.getResultList();

        //return
        return duels;
    }

    @Override
    public Duel findById(int theId) {
        Duel theDuel = entityManager.find(Duel.class, theId);

        return theDuel;
    }

    @Override
    public Duel save(Duel theDuel) {
        Duel dbDuel = entityManager.merge(theDuel);

        return dbDuel;
    }

    @Override
    public void deleteById(int theId) {
        Duel theDuel = entityManager.find(Duel.class, theId);

        entityManager.remove(theDuel);
    }
}
