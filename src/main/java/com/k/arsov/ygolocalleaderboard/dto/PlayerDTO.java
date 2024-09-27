package com.k.arsov.ygolocalleaderboard.dto;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.DeckWinLossDrawRatio;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRate;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerWinLossDrawRatio;

import java.util.List;

public class PlayerDTO
{
    private Player player;
    private PlayerWinLossDrawRatio playerWinLossDrawRatio;
    private List<PlayerDeckWinRate> playerDeckWinRates;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerWinLossDrawRatio getPlayerWinLossDrawRatio() {
        return playerWinLossDrawRatio;
    }

    public void setPlayerWinLossDrawRatio(PlayerWinLossDrawRatio playerWinLossDrawRatio) {
        this.playerWinLossDrawRatio = playerWinLossDrawRatio;
    }

    public List<PlayerDeckWinRate> getPlayerDeckWinRates() {
        return playerDeckWinRates;
    }

    public void setPlayerDeckWinRates(List<PlayerDeckWinRate> playerDeckWinRates) {
        this.playerDeckWinRates = playerDeckWinRates;
    }
}
