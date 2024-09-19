package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SetCardDAO implements DAO<SetCard>
{
    private EntityManager entityManager;

        @Autowired
        public SetCardDAO(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    @Override
    public List<SetCard> findAll() {
        //create query
        TypedQuery<SetCard> theQuery = entityManager.createQuery("from SetCard", SetCard.class);

        //execute query
        List<SetCard> deckCards = theQuery.getResultList();

        //return
        return deckCards;
    }

    @Override
    public SetCard findById(int theId) {
        SetCard theDeckCard = entityManager.find(SetCard.class, theId);

        return theDeckCard;
    }

    @Override
    public SetCard save(SetCard theDeckCard) {
        SetCard dbDeckCard = entityManager.merge(theDeckCard);

        return dbDeckCard;
    }

    @Override
    public void deleteById(int theId) {
        SetCard theDeckCard = entityManager.find(SetCard.class, theId);

        entityManager.remove(theDeckCard);
    }
}
