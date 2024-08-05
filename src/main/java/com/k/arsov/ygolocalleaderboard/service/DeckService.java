package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DAO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DeckService implements Service
{
    public DAO DAO;

    @Autowired
    public DeckService(DAO theDAO)
    {
        DAO = theDAO;
    }

    @Override
    public List<Deck> findAll() {
        return DAO.findAll();
    }

    @Override
    public Deck findById(int theId) {
        return DAO.findById(theId);
    }

    @Transactional
    @Override
    public Deck save(Deck theDeck) {
        return DAO.save(theDeck);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        DAO.deleteById(theId);
    }
}
