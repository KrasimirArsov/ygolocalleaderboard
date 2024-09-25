package com.k.arsov.ygolocalleaderboard.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="deck")
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "deck_set_card",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "set_card_id")
    )
    private List<SetCard> setCards;

    public Deck()
    {

    }

    public Deck(int id, String name, List<SetCard> setCards) {
        this.id = id;
        this.name = name;
        this.setCards = setCards;
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

    public List<SetCard> getSetCards() {
        return setCards;
    }

    public void setDeckCards(List<SetCard> setCards) {
        this.setCards = setCards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deckCards=" + setCards +
                '}';
    }
}
