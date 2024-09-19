package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class ExternalYGOProService
{
    private long timeOfLastExternalRequest;
    private final long incrementInMilliseconds = 60;

    public SetCard fetchSetCard(String cardSet) {
        String url="https://db.ygoprodeck.com/api/v7/cardsetsinfo.php?setcode=" + cardSet;
        RestTemplate template = new RestTemplate();
        SetCard sc= template.getForObject(url, SetCard.class);

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return sc;
    }
}
