package com.k.arsov.ygolocalleaderboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private String role;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id", unique = true, nullable = false)
    private Player player;

    public User() {
    }

    public User(int id, String username, String password, String role, Player player) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}