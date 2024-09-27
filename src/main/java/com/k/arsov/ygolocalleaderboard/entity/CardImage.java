package com.k.arsov.ygolocalleaderboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "card_image")
public class CardImage {

    @Id
    @Column(name = "id", length = 255)
    private String id;  // Represents the file name on the file system

    @Column(name = "artwork")
    private Integer artwork;  // Integer field for the artwork

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "effective_card_id")  // Foreign key to the effective_card table
    private EffectiveCard effectiveCard;  // Reference to EffectiveCard entity

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getArtwork() {
        return artwork;
    }

    public void setArtwork(Integer artwork) {
        this.artwork = artwork;
    }

    public EffectiveCard getEffectiveCard() {
        return effectiveCard;
    }

    public void setEffectiveCard(EffectiveCard effectiveCard) {
        this.effectiveCard = effectiveCard;
    }
}
