package com.k.arsov.ygolocalleaderboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "avatar")
public class Avatar {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    // Constructors
    public Avatar() {}

    public Avatar(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}