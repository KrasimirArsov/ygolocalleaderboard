package com.k.arsov.ygolocalleaderboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_win_loss_draw_ratios")
public class PlayerWinLossDrawRatio {

    @Id
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "player_name")
    private String playerName;

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
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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
