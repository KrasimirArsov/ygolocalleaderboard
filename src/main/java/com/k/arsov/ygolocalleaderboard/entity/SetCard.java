package com.k.arsov.ygolocalleaderboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="set_card")
public class SetCard
{
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "name")
    private EffectiveCard effectiveCard;

    @JsonProperty("set_name")
    @Column(name="set_name")
    private String setName;

    @JsonProperty("set_code")
    @Id
    @Column(name="set_code")
    private String setCode;

    @Column(name="set_rarity")
    @JsonProperty("set_rarity")
    private String setRarity;

    @Column(name="set_price")
    @JsonProperty("set_price")
    private double setPrice;

    @Column(name="artwork")
    @JsonProperty("artwork")
    private int artwork;

    public SetCard()
    {

    }

    public SetCard(EffectiveCard effectiveCard, String setName, String setCode, String setRarity, double setPrice) {
        this.effectiveCard = effectiveCard;
        this.setName = setName;
        this.setCode = setCode;
        this.setRarity = setRarity;
        this.setPrice = setPrice;
    }

    public EffectiveCard getEffectiveCard() {
        return effectiveCard;
    }

    public void setEffectiveCard(EffectiveCard effectiveCard) {
        this.effectiveCard = effectiveCard;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getSetRarity() {
        return setRarity;
    }

    public void setSetRarity(String setRarity) {
        this.setRarity = setRarity;
    }

    public double getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(double setPrice) {
        this.setPrice = setPrice;
    }

    public int getArtwork() {
        return artwork;
    }

    public void setArtwork(int artwork) {
        this.artwork = artwork;
    }

    @Override
    public String toString() {
        return "SetCardDetails{" +
                ", setName='" + setName + '\'' +
                ", setCode='" + setCode + '\'' +
                ", setRarity='" + setRarity + '\'' +
                ", setPrice='" + setPrice + '\'' +
                '}';
    }
}
