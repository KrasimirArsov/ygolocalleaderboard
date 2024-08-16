package com.k.arsov.ygolocalleaderboard.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetCard
{
    private String name;
    @JsonProperty("set_name")
    private String setName;
    @JsonProperty("set_code")
    private String setCode;
    @JsonProperty("set_rarity")
    private String setRarity;
    @JsonProperty("set_price")
    private String setPrice;

    public SetCard()
    {

    }

    public SetCard(String name, String setName, String setCode, String setRarity, String setPrice) {
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

    public String getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(String setPrice) {
        this.setPrice = setPrice;
    }
}
