package com.k.arsov.ygolocalleaderboard.entity;

import com.k.arsov.ygolocalleaderboard.entity.misc.WinCondition;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name="duel")
public class Duel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "player_one_id")
    private Player player1;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "deck_one_id")
    private Deck deck1;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "player_two_id")
    private Player player2;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "deck_two_id")
    private Deck deck2;

    @Column(name = "result")
    private int result;

    @Enumerated(EnumType.STRING)
    @Column(name = "win_condition")
    private WinCondition winCondition;

    @Column(name = "duel_date")
    private Timestamp duelDate;

    public Duel()
    {

    }

    public Duel(int id, Player player1, Deck deck1, Player player2, Deck deck2, int result, WinCondition winCondition) {
        this.id = id;
        this.player1 = player1;
        this.deck1 = deck1;
        this.player2 = player2;
        this.deck2 = deck2;
        this.result = result;
        this.winCondition = winCondition;
        this.duelDate = Timestamp.from(Instant.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Deck getDeck1() {
        return deck1;
    }

    public void setDeck1(Deck deck1) {
        this.deck1 = deck1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Deck getDeck2() {
        return deck2;
    }

    public void setDeck2(Deck deck2) {
        this.deck2 = deck2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public WinCondition getWinCondition() {
        return winCondition;
    }

    public void setWinCondition(WinCondition winCondition) {
        this.winCondition = winCondition;
    }

    public Timestamp getDate() {
        return duelDate;
    }

    public void setDate(Timestamp timestamp) {
        this.duelDate = timestamp;
    }
}
