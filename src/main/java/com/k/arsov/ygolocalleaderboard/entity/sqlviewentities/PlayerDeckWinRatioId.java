package com.k.arsov.ygolocalleaderboard.entity.sqlviewentities;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerDeckWinRatioId implements Serializable {

//    @JsonUnwrapped // Ensures that playerId and deckId appear at the root level in JSON
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "deck_id")
    private int deckId;

    public PlayerDeckWinRatioId() {
    }

    public PlayerDeckWinRatioId(int playerId, int deckId) {
        this.playerId = playerId;
        this.deckId = deckId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDeckWinRatioId that = (PlayerDeckWinRatioId) o;
        return playerId == that.playerId && deckId == that.deckId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, deckId);
    }
}