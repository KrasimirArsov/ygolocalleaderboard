package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.DeckWinLossDrawRatio;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeckDAO
{
    private EntityManager entityManager;

        @Autowired
        public DeckDAO(EntityManager theEntityManager)
        {
            entityManager = theEntityManager;
        }

    public List<Deck> findAll() {
        //create query
        TypedQuery<Deck> theQuery = entityManager.createQuery("from Deck", Deck.class);

        //execute query
        List<Deck> decks = theQuery.getResultList();

        //return
        return decks;
    }

    public Deck findById(int theId) {
        Deck theDeck = entityManager.find(Deck.class, theId);

        return theDeck;
    }

    public Deck findByName(String theName) {
        //create query
        TypedQuery<Deck> theQuery = entityManager.createQuery("from Deck where name='" + theName + "'", Deck.class);

        //execute query
        Deck theDeck = theQuery.getResultList().get(0);

        return theDeck;
    }

    public Deck save(Deck theDeck) {
        Deck dbDeck = entityManager.merge(theDeck);

        return dbDeck;
    }

    public void deleteById(int theId) {
        Deck theDeck = entityManager.find(Deck.class, theId);

        entityManager.remove(theDeck);
    }

    public List<DeckWinLossDrawRatio> findAllWinLossDrawRatio() {
        //create query
        TypedQuery<DeckWinLossDrawRatio> theQuery = entityManager.createQuery("from DeckWinLossDrawRatio d where d.totalDuels >=3 ORDER BY d.winRatio DESC", DeckWinLossDrawRatio.class);

        //execute query
        List<DeckWinLossDrawRatio> decksWLDRatios = theQuery.getResultList();

        //return
        return decksWLDRatios;
    }

    public DeckWinLossDrawRatio findByIdWinLossDrawRatio(int theId) {
        DeckWinLossDrawRatio theDecksWLDRatio = entityManager.find(DeckWinLossDrawRatio.class, theId);

        return theDecksWLDRatio;
    }

    public List<PlayerDeckWinRate> findAllPlayerDeckWinRateByDeckId(int theDeckId)
    {
        TypedQuery<PlayerDeckWinRate> theQuery = entityManager.createQuery("from PlayerDeckWinRate p where p.deckId=" + theDeckId + " ORDER BY p.winRate DESC", PlayerDeckWinRate.class);

        List<PlayerDeckWinRate> deckWinRatesByPlayers = theQuery.getResultList();

        return deckWinRatesByPlayers;
    }
}
