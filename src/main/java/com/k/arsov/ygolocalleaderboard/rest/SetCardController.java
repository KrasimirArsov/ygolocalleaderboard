package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SetCardController
{
    @GetMapping("/set-cards/{cardSet}")
    public SetCard findBySet(@PathVariable String cardSet)
    {
        String url="https://db.ygoprodeck.com/api/v7/cardsetsinfo.php?setcode=" + cardSet;
        RestTemplate template = new RestTemplate();
        SetCard sc= template.getForObject(url, SetCard.class);

        return sc;
    }
}
