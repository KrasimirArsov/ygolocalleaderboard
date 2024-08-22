package com.k.arsov.ygolocalleaderboard.entity;

import com.k.arsov.ygolocalleaderboard.entity.external.SetCard;
import jakarta.persistence.*;

import java.util.List;

public class DeckCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="setCard")
    private String setCard;
}
