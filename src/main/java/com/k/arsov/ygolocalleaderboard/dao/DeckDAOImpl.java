package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeckDAOImpl implements DeckDAO
{
    private EntityManager entityManager;

        @Autowired
        public DeckDAOImpl(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    @Override
    public List<Deck> findAll() {
        //create query
        TypedQuery<Deck> theQuery = entityManager.createQuery("from Deck", Deck.class);

        //execute query
        List<Deck> decks = theQuery.getResultList();

        //return
        return decks;
    }

    @Override
    public Deck findById(int theId) {
        Deck theDeck = entityManager.find(Deck.class, theId);

        return theDeck;
    }

    @Override
    public Deck save(Deck theDeck) {
        Deck dbDeck = entityManager.merge(theDeck);

        return dbDeck;
    }

    @Override
    public void deleteById(int theId) {
        Deck theDeck = entityManager.find(Deck.class, theId);

        entityManager.remove(theDeck);
    }
}
