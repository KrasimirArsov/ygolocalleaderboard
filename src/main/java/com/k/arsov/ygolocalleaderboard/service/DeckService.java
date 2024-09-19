package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DAO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DeckService implements CRUDService<Deck>
{
    public DAO<Deck> deckDAO;

    @Autowired
    public DeckService(DAO<Deck> theDeckDAO)
    {
        deckDAO = theDeckDAO;
    }

    @Override
    public List<Deck> findAll() {
        return deckDAO.findAll();
    }

    @Override
    public Deck findById(int theId) {
        return deckDAO.findById(theId);
    }

    @Transactional
    @Override
    public Deck save(Deck theDeck) {
        return deckDAO.save(theDeck);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        deckDAO.deleteById(theId);
    }
}
