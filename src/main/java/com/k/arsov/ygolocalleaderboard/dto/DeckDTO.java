package com.k.arsov.ygolocalleaderboard.dto;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.DeckWinLossDrawRatio;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRate;

import java.util.List;

public class DeckDTO
{
    private Deck deck;
    private DeckWinLossDrawRatio deckWinLossDrawRatio;
    private List<PlayerDeckWinRate> playerDeckWinRates;

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public DeckWinLossDrawRatio getDeckWinLossDrawRatio() {
        return deckWinLossDrawRatio;
    }

    public void setDeckWinLossDrawRatio(DeckWinLossDrawRatio deckWinLossDrawRatio) {
        this.deckWinLossDrawRatio = deckWinLossDrawRatio;
    }

    public List<PlayerDeckWinRate> getPlayerDeckWinRates() {
        return playerDeckWinRates;
    }

    public void setPlayerDeckWinRates(List<PlayerDeckWinRate> playerDeckWinRates) {
        this.playerDeckWinRates = playerDeckWinRates;
    }
}
