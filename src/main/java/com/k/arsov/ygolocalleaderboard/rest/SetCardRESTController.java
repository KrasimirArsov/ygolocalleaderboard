package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.external.SetCard;
import com.k.arsov.ygolocalleaderboard.service.ExternalYGOProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SetCardRESTController
{
    private ExternalYGOProService setCardService;

    @Autowired
    public SetCardRESTController(ExternalYGOProService theService)
    {
        setCardService = theService;
    }

    @GetMapping("/set-cards/{cardSet}")
    public SetCard findBySet(@PathVariable String cardSet)
    {
        return setCardService.fetchSetCard(cardSet);
    }
}
