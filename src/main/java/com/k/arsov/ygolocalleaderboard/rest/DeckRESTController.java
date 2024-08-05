package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeckRESTController
{
    private DeckService deckService;

    @Autowired
    public DeckRESTController(DeckService theDeckService)
    {
        deckService = theDeckService;
    }


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
            throw new RuntimeException("Deck ID not found." + deckId);
        }

        return theDeck;
    }

    @PostMapping("/decks")
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
    public String deleteDeck(@PathVariable int deckId)
    {
        Deck tempDeck = deckService.findById(deckId);

        if(tempDeck == null)
        {
            throw new RuntimeException("Deck id not found - " + deckId);
        }

        deckService.deleteById(deckId);

        return "Deleted deck with id - " + deckId;
    }
}
