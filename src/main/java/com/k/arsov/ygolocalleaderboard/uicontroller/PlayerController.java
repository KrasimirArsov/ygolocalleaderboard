package com.k.arsov.ygolocalleaderboard.uicontroller;

import com.k.arsov.ygolocalleaderboard.dto.DeckDTO;
import com.k.arsov.ygolocalleaderboard.dto.PlayerDTO;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.service.DeckService;
import com.k.arsov.ygolocalleaderboard.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController
{
    @Autowired
    private PlayerService playerService;

    @Autowired
    private DeckService deckService;

    @GetMapping("/players")
    public String listPlayers(Model model)
    {
        List<PlayerDTO> playerList = playerService.getAllPlayerDTOs();
        model.addAttribute("playerList", playerList);

        return "players/list";
    }

//    @GetMapping("/players/{id}")
//    public String viewDeck(@PathVariable("id") int id, Model model) {
//        PlayerDTO playerDTO = playerService.getPlayerDTOById(id);
//        model.addAttribute("playerDTO", playerDTO);
//
//        model.addAttribute("decksMap", deckService.getAllDecksAsMap());
//
//        return "players/view"; // Returns the single deck view
//    }

    @GetMapping("/players/{name}")
    public String viewDeckByName(@PathVariable("name") String name, Model model) {
        PlayerDTO playerDTO = playerService.getPlayerDTOByName(name);
        model.addAttribute("playerDTO", playerDTO);

        model.addAttribute("decksMap", deckService.getAllDecksAsMap());

        return "players/view"; // Returns the single deck view
    }
}
