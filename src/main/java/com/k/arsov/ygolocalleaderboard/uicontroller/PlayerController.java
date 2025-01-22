package com.k.arsov.ygolocalleaderboard.uicontroller;

import com.k.arsov.ygolocalleaderboard.dto.DeckDTO;
import com.k.arsov.ygolocalleaderboard.dto.PlayerDTO;
import com.k.arsov.ygolocalleaderboard.entity.Avatar;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.service.AvatarService;
import com.k.arsov.ygolocalleaderboard.service.DeckService;
import com.k.arsov.ygolocalleaderboard.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PlayerController
{
    @Autowired
    private PlayerService playerService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/players")
    public String listPlayers(Model model)
    {
        List<PlayerDTO> playerList = playerService.getAllPlayerDTOs();
        model.addAttribute("playerList", playerList);

        return "players/list";
    }

    @GetMapping("/players/{name}")
    public String viewPlayerByName(@PathVariable("name") String name, Model model) {
        PlayerDTO playerDTO = playerService.getPlayerDTOByName(name);
        model.addAttribute("playerDTO", playerDTO);

        model.addAttribute("decksMap", deckService.getAllDecksAsMap());

        return "players/view";
    }

    @GetMapping("/players/create")
    public String createPlayer(Model model) {
        model.addAttribute("playersNames", playerService.getAllPlayersNames());

        model.addAttribute("player", new Player());

        return "players/create";
    }

    @PostMapping("/players/save")
    public String viewDeckByName(Player player) {
        playerService.save(player);
        return "redirect:/players";
    }

    @PostMapping("/players/delete/{id}")
    public String deletePlayer(@PathVariable("id") int id) {
        playerService.deleteById(id);

        return "redirect:/players";
    }

    @GetMapping("/players/edit/{id}")
    public String showEditPlayerForm(@PathVariable("id") int id, Model model) {
        // Find the player by ID
        Player player = playerService.findById(id);

        // Add the player to the model to populate the form
        model.addAttribute("player", player);

        return "players/edit"; // Return the edit form view
    }

    @PostMapping("/players/edit/{id}")
    public String updatePlayer(@PathVariable("id") int id, Player player) {
        // Retrieve the existing player
        Player existingPlayer = playerService.findById(id);

        // Update player fields
        existingPlayer.setName(player.getName());

        // Save the updated player back to the database
        playerService.save(existingPlayer);

        // Redirect to the player list after saving
        return "redirect:/players";
    }
}
