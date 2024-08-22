package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.entity.external.SetCard;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class ExternalYGOProService
{
    private long timeOfLastExternalRequest;
    private final long incrementInMilliseconds = 60;

    public ExternalYGOProService()
    {
        setTimeOfLastExternalRequestToNow();
    }

    public SetCard fetchSetCard(String cardSet) {
        String url="https://db.ygoprodeck.com/api/v7/cardsetsinfo.php?setcode=" + cardSet;
        RestTemplate template = new RestTemplate();
        SetCard sc= template.getForObject(url, SetCard.class);

        while(!checkIfIncrementPassed())
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Slept for 10ms");
        }

        setTimeOfLastExternalRequestToNow();

        return sc;
    }

    public void setTimeOfLastExternalRequestToNow() {
        this.timeOfLastExternalRequest = System.currentTimeMillis();
    }

    private boolean checkIfIncrementPassed()
    {
        System.out.println(timeOfLastExternalRequest + incrementInMilliseconds - System.currentTimeMillis());
        if(timeOfLastExternalRequest + incrementInMilliseconds - System.currentTimeMillis() < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
