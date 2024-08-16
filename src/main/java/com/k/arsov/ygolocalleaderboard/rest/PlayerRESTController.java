package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.rest.response.ErrorResponse;
import com.k.arsov.ygolocalleaderboard.rest.response.NotFoundException;
import com.k.arsov.ygolocalleaderboard.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerRESTController
{
    private Service<Player> playerService;

    @Autowired
    public PlayerRESTController(Service<Player> thePlayerService)
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
            throw new NotFoundException("Player ID not found." + playerId);
        }

        return thePlayer;
    }

    @PostMapping("/players")
    public ResponseEntity<Player> addPlayer(@RequestBody Player thePlayer)
    {
        thePlayer.setId(0);

        Player dbPlayer = playerService.save(thePlayer);

        ResponseEntity<Player> response = new ResponseEntity<>(dbPlayer, HttpStatus.CREATED);

        return response;
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
            throw new NotFoundException("Player id not found - " + playerId);
        }

        playerService.deleteById(playerId);

        return "Deleted player with id - " + playerId;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exc)
    {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
