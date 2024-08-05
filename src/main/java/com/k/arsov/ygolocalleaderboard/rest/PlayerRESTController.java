package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerRESTController
{
    private PlayerService playerService;

    @Autowired
    public PlayerRESTController(PlayerService thePlayerService)
    {
        playerService = thePlayerService;
    }


    @GetMapping("/players")
    public List<Player> findAll()
    {
        return playerService.findAll();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayer(@PathVariable int playerId)
    {
        Player thePlayer = playerService.findById(playerId);

        if(thePlayer == null)
        {
            throw new RuntimeException("Player ID not found." + playerId);
        }

        return thePlayer;
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player thePlayer)
    {
        thePlayer.setId(0);

        Player dbPlayer = playerService.save(thePlayer);

        return dbPlayer;
    }

    @PutMapping("/players")
    public Player updateDeck(@RequestBody Player thePlayer)
    {
        Player dbPlayer = playerService.save(thePlayer);

        return dbPlayer;
    }

    @DeleteMapping("/players/{playerId}")
    public String deletePlayer(@PathVariable int playerId)
    {
        Player tempPlayer = playerService.findById(playerId);

        if(tempPlayer == null)
        {
            throw new RuntimeException("Player id not found - " + playerId);
        }

        playerService.deleteById(playerId);

        return "Deleted player with id - " + playerId;
    }
}
