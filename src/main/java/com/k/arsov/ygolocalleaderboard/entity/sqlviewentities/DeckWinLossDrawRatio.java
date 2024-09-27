package com.k.arsov.ygolocalleaderboard.entity.sqlviewentities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "deck_win_loss_draw_ratios")
public class DeckWinLossDrawRatio {

    @Id
    @Column(name = "deck_id")
    private int deckId;

    @Column(name = "deck_name")
    private String deckName;

    @Column(name = "total_duels")
    private int totalDuels;

    @Column(name = "total_wins")
    private int totalWins;

    @Column(name = "total_losses")
    private int totalLosses;

    @Column(name = "total_draws")
    private int totalDraws;

    @Column(name = "win_ratio")
    private double winRatio;

    @Column(name = "loss_ratio")
    private double lossRatio;

    @Column(name = "draw_ratio")
    private double drawRatio;

    // Getters and Setters
    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public int getTotalDuels() {
        return totalDuels;
    }

    public void setTotalDuels(int totalDuels) {
        this.totalDuels = totalDuels;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getTotalDraws() {
        return totalDraws;
    }

    public void setTotalDraws(int totalDraws) {
        this.totalDraws = totalDraws;
    }

    public double getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(double winRatio) {
        this.winRatio = winRatio;
    }

    public double getLossRatio() {
        return lossRatio;
    }

    public void setLossRatio(double lossRatio) {
        this.lossRatio = lossRatio;
    }

    public double getDrawRatio() {
        return drawRatio;
    }

    public void setDrawRatio(double drawRatio) {
        this.drawRatio = drawRatio;
    }
}
