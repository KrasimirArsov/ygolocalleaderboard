package com.k.arsov.ygolocalleaderboard.entity.sqlviewentities;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable // Hibernate annotation to mark this entity as read-only (use org.hibernate.annotations.Immutable)
@Table(name = "player_deck_win_rate") // The name of the view in the database
public class PlayerDeckWinRatio {

    @EmbeddedId
    private PlayerDeckWinRatioId id;

    @Column(name = "player_id", nullable = false, insertable = false, updatable = false)
    private int playerId;

    @Column(name = "deck_id", nullable = false, insertable = false, updatable = false)
    private int deckId;

    @Column(name = "total_duels", nullable = false)
    private long totalDuels;

    @Column(name = "wins", nullable = false)
    private long wins;

    @Column(name = "win_rate", nullable = false)
    private double winRate;

    public String getId() {
        return playerId + "/" + deckId;
    }

    // Constructors
    public PlayerDeckWinRatio() {
    }

    public PlayerDeckWinRatio(PlayerDeckWinRatioId id, int playerId, int deckId, long totalDuels, long wins, double winRate) {
        this.id = id;
        this.playerId = playerId;
        this.deckId = deckId;
        this.totalDuels = totalDuels;
        this.wins = wins;
        this.winRate = winRate;
    }

    // Getters and setters
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

    public long getTotalDuels() {
        return totalDuels;
    }

    public void setTotalDuels(long totalDuels) {
        this.totalDuels = totalDuels;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    @Override
    public String toString() {
        return "PlayerDeckWinRate{" +
                "id=" + id +
                "playerId=" + playerId +
                ", deckId=" + deckId +
                ", totalDuels=" + totalDuels +
                ", wins=" + wins +
                ", winRate=" + winRate +
                '}';
    }
}

