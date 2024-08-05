package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.entity.Deck;

import java.util.List;

public interface DeckService
{
    List<Deck> findAll();

    Deck findById(int theId);

    Deck save(Deck theDeck);

    void deleteById(int theId);
}
