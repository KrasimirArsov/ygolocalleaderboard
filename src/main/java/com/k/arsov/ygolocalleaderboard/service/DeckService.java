package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DeckDAO;
import com.k.arsov.ygolocalleaderboard.dto.DeckDTO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.DeckWinLossDrawRatio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public DeckDTO getDeckDTOById(int theId)
    {
        DeckDTO deckDTO = new DeckDTO();
        deckDTO.setDeck(deckDAO.findById(theId));
        deckDTO.setDeckWinLossDrawRatio(deckDAO.findByIdWinLossDrawRatio(theId));
        deckDTO.setPlayerDeckWinRates(deckDAO.findAllPlayerDeckWinRateByDeckId(theId));

        return deckDTO;
    }

    public DeckDTO getDeckDTOByName(String theName)
    {
        DeckDTO deckDTO = new DeckDTO();
        deckDTO.setDeck(deckDAO.findByName(theName));
        deckDTO.setDeckWinLossDrawRatio(deckDAO.findByIdWinLossDrawRatio(deckDTO.getDeck().getId()));
        deckDTO.setPlayerDeckWinRates(deckDAO.findAllPlayerDeckWinRateByDeckId(deckDTO.getDeck().getId()));

        return deckDTO;
    }

    public Map<Integer, Deck> getAllDecksAsMap()
    {
        return findAll().stream()
                .collect(Collectors.toMap(Deck::getId, deck -> deck));
    }
}
