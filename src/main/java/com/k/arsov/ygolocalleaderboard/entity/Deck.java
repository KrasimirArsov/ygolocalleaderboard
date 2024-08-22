package com.k.arsov.ygolocalleaderboard.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Deck")
public class Deck
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "deckId")
    private List<DeckCard> cards;

    public Deck()
    {

    }

    public Deck(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Deck(int id, String name, List<DeckCard> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeckCard> getCards() {
        return cards;
    }

    public void setCards(List<DeckCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
