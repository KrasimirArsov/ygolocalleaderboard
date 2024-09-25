package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import com.k.arsov.ygolocalleaderboard.rest.exceptions.response.NotFoundException;
import com.k.arsov.ygolocalleaderboard.service.CRUDService;
import com.k.arsov.ygolocalleaderboard.service.ExternalYGOProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DeckRESTController
{
    private CRUDService<Deck> deckService;

    @Autowired
    public DeckRESTController(CRUDService<Deck> theDeckService)
    {
        deckService = theDeckService;
    }

    @Autowired
    private ExternalYGOProService setCardService;


    @GetMapping("/decks")
    public List<Deck> findAll()
    {


        return deckService.findAll();
    }

    @GetMapping("/decks/{deckId}")
    public Deck getDeck(@PathVariable int deckId)
    {
        Deck theDeck = deckService.findById(deckId);

        if(theDeck == null)
        {
            throw new NotFoundException("Deck ID not found." + deckId);
        }

        return theDeck;
    }

    @GetMapping("/decks/{deckId}/cards-details")
    public List<SetCard> getDecksCardsDetails(@PathVariable int deckId)
    {
        Deck theDeck = deckService.findById(deckId);

        if(theDeck == null)
        {
            throw new NotFoundException("Deck ID not found." + deckId);
        }

        List<SetCard> cardDetails = new ArrayList<>();

        return cardDetails;
    }

    @PostMapping("/decks")
    @ResponseStatus(HttpStatus.CREATED)
    public Deck addDeck(@RequestBody Deck theDeck)
    {
        theDeck.setId(0);

        Deck dbDeck = deckService.save(theDeck);

        return dbDeck;
    }

    @PutMapping("/decks")
    public Deck updateDeck(@RequestBody Deck theDeck)
    {
        Deck dbDeck = deckService.save(theDeck);

        return dbDeck;
    }

    @DeleteMapping("/decks/{deckId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeck(@PathVariable int deckId)
    {
        Deck tempDeck = deckService.findById(deckId);

        if(tempDeck == null)
        {
            throw new NotFoundException("Deck id not found - " + deckId);
        }

        deckService.deleteById(deckId);

    }
}
