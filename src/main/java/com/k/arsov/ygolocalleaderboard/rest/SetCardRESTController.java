package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import com.k.arsov.ygolocalleaderboard.rest.response.NotFoundException;
import com.k.arsov.ygolocalleaderboard.service.CRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SetCardRESTController
{
    private static final Logger logger = LoggerFactory.getLogger(SetCardRESTController.class);
    private CRUDService<SetCard> deckCardService;

    @Autowired
    public SetCardRESTController(CRUDService<SetCard> theDeckCardService)
    {
        deckCardService = theDeckCardService;
    }


    @GetMapping("/set-cards")
    public List<SetCard> findAll()
    {
        return deckCardService.findAll();
    }

    @GetMapping("/set-cards/{deckCardId}")
    public SetCard getDeckCard(@PathVariable int deckCardId)
    {
        SetCard theDeckCard = deckCardService.findById(deckCardId);

        if(theDeckCard == null)
        {
            throw new NotFoundException("DeckCard ID not found." + deckCardId);
        }

        return theDeckCard;
    }

    @PutMapping("/set-cards")
    public SetCard updateDeckCard(@RequestBody SetCard theDeckCard)
    {
        SetCard dbPlayer = deckCardService.save(theDeckCard);

        return dbPlayer;
    }

    @DeleteMapping("/set-cards/{deckCardId}")
    public String deleteDeckCard(@PathVariable int deckCardId)
    {
        SetCard tempDeckCard = deckCardService.findById(deckCardId);

        if(tempDeckCard == null)
        {
            throw new NotFoundException("DeckCard id not found - " + deckCardId);
        }

        deckCardService.deleteById(deckCardId);

        return "Deleted DeckCard with id - " + deckCardId;
    }
}
