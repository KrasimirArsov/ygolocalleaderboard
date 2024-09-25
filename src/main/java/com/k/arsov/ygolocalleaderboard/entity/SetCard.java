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
    @Column(name="name")
    private String name;

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

    public SetCard()
    {

    }

    public SetCard(String name, String setName, String setCode, String setRarity, double setPrice) {
        this.name = name;
        this.setName = setName;
        this.setCode = setCode;
        this.setRarity = setRarity;
        this.setPrice = setPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "SetCardDetails{" +
                "name='" + name + '\'' +
                ", setName='" + setName + '\'' +
                ", setCode='" + setCode + '\'' +
                ", setRarity='" + setRarity + '\'' +
                ", setPrice='" + setPrice + '\'' +
                '}';
    }
}
