package com.k.arsov.ygolocalleaderboard.uicontroller;

import com.k.arsov.ygolocalleaderboard.dto.DeckDTO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.Duel;
import com.k.arsov.ygolocalleaderboard.entity.misc.WinCondition;
import com.k.arsov.ygolocalleaderboard.service.DeckService;
import com.k.arsov.ygolocalleaderboard.service.DuelService;
import com.k.arsov.ygolocalleaderboard.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DuelController {

    @Autowired
    private DuelService duelService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private PlayerService playerService;

    // Display all decks
    @GetMapping("/duels")
    public String listDuels(Model model) {
        List<Duel> duels = duelService.findAll();
        model.addAttribute("duels", duels);

        model.addAttribute("playersMap", playerService.getAllPlayersAsMap());

        model.addAttribute("decksMap", deckService.getAllDecksAsMap());

        return "duels/list"; // Returns the decks list view
    }

    // Display a single deck by ID
//    @GetMapping("/decks/{id}")
//    public String viewDeck(@PathVariable("id") int id, Model model) {
//        DeckDTO deckDTO = deckService.getDeckDTOById(id);
//        model.addAttribute("deckDTO", deckDTO);
//
//        model.addAttribute("playersMap", playerService.getAllPlayersAsMap());
//
//        return "decks/view"; // Returns the single deck view
//    }

    @GetMapping("/duels/{name}")
    public String viewDeckByName(@PathVariable("name") String name, Model model) {
        DeckDTO deckDTO = deckService.getDeckDTOByName(name);
        model.addAttribute("deckDTO", deckDTO);

        model.addAttribute("playersMap", playerService.getAllPlayersAsMap());

        return "decks/view"; // Returns the single deck view
    }

    // Show the form for creating a new deck
    @GetMapping("/duels/create")
    public String showCreateDeckForm(Model model) {
        model.addAttribute("duel", new Duel());

        model.addAttribute("players", playerService.findAll());
        model.addAttribute("decks", deckService.findAll());
        model.addAttribute("winConditions", WinCondition.values());
        return "duels/create";
    }

    // Handle the form submission for creating a new deck
    @PostMapping("/duels/save")
    public String createDuel(@ModelAttribute Duel duel) {
        System.out.println(duel);
        //duelService.save(duel); // Ensure you have a service to handle duels
        return "redirect:/duels"; // Redirect to the list of duels
    }
}
