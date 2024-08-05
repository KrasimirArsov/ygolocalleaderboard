package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeckRESTController
{
    private Service service;

    @Autowired
    public DeckRESTController(Service theService)
    {
        service = theService;
    }


    @GetMapping("/decks")
    public List<Deck> findAll()
    {
        return service.findAll();
    }

    @GetMapping("/decks/{deckId}")
    public Deck getDeck(@PathVariable int deckId)
    {
        Deck theDeck = service.findById(deckId);

        if(theDeck == null)
        {
            throw new RuntimeException("Deck ID not found." + deckId);
        }

        return theDeck;
    }

    @PostMapping("/decks")
    public Deck addDeck(@RequestBody Deck theDeck)
    {
        theDeck.setId(0);

        Deck dbDeck = service.save(theDeck);

        return dbDeck;
    }

    @PutMapping("/decks")
    public Deck updateDeck(@RequestBody Deck theDeck)
    {
        Deck dbDeck = service.save(theDeck);

        return dbDeck;
    }

    @DeleteMapping("/decks/{deckId}")
    public String deleteDeck(@PathVariable int deckId)
    {
        Deck tempDeck = service.findById(deckId);

        if(tempDeck == null)
        {
            throw new RuntimeException("Deck id not found - " + deckId);
        }

        service.deleteById(deckId);

        return "Deleted deck with id - " + deckId;
    }
}
