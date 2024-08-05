package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DeckDAO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DeckServiceImpl implements DeckService
{
    public DeckDAO DeckDAO;

    @Autowired
    public DeckServiceImpl(DeckDAO theDeckDAO)
    {
        DeckDAO = theDeckDAO;
    }

    @Override
    public List<Deck> findAll() {
        return DeckDAO.findAll();
    }

    @Override
    public Deck findById(int theId) {
        return DeckDAO.findById(theId);
    }

    @Transactional
    @Override
    public Deck save(Deck theDeck) {
        return DeckDAO.save(theDeck);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        DeckDAO.deleteById(theId);
    }
}
