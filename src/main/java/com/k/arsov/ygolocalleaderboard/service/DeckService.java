package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DeckDAO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.DeckWinLossDrawRatio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DeckService implements CRUDService<Deck>
{
    public DeckDAO deckDAO;

    @Autowired
    public DeckService(DeckDAO theDeckDAO)
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

    public List<DeckWinLossDrawRatio> findAllDeckWinLossDrawRatio() {
        return deckDAO.findAllWinLossDrawRatio();
    }

    public DeckWinLossDrawRatio findByIdIdWinLossDrawRatio(int theId) {
        return deckDAO.findByIdWinLossDrawRatio(theId);
    }

    public List<DeckWinLossDrawRatio> findTopDeckWinLossDrawRatio(int numOfTopDeckWinLossDrawRatios) {
        List<DeckWinLossDrawRatio> returnList = deckDAO.findAllWinLossDrawRatio();

        return returnList.subList(0, Math.min(numOfTopDeckWinLossDrawRatios, returnList.size()));
    }

}
