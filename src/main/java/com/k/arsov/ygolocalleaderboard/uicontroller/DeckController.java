package com.k.arsov.ygolocalleaderboard.uicontroller;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeckController {

    @Autowired
    private DeckService deckService;

    // Display all decks
    @GetMapping("/decks")
    public String listDecks(Model model) {
        List<Deck> decks = deckService.findAll();
        model.addAttribute("decks", decks);
        return "decks/list"; // Returns the decks list view
    }

    // Display a single deck by ID
    @GetMapping("/decks/{id}")
    public String viewDeck(@PathVariable("id") int id, Model model) {
        Deck deck = deckService.findById(id);
        model.addAttribute("deck", deck);
        return "decks/view"; // Returns the single deck view
    }

    // Show the form for creating a new deck
    @GetMapping("/decks/new")
    public String showCreateDeckForm(Model model) {
        model.addAttribute("deck", new Deck());
        return "decks/create";
    }

    // Handle the form submission for creating a new deck
    @PostMapping("/decks")
    public String createDeck(Deck deck) {
        deckService.save(deck);
        return "redirect:/decks"; // Redirect to the list of decks
    }
}
