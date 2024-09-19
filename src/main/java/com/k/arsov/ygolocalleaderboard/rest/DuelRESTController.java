package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.Duel;
import com.k.arsov.ygolocalleaderboard.rest.response.ErrorResponse;
import com.k.arsov.ygolocalleaderboard.rest.response.NotFoundException;
import com.k.arsov.ygolocalleaderboard.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DuelRESTController
{
    private CRUDService<Duel> duelService;

    @Autowired
    public DuelRESTController(CRUDService<Duel> theDuelService)
    {
        duelService = theDuelService;
    }


    @GetMapping("/duels")
    public List<Duel> findAll()
    {
        return duelService.findAll();
    }

    @GetMapping("/duels/{duelId}")
    public Duel getDuel(@PathVariable int duelId)
    {
        Duel theDuel = duelService.findById(duelId);

        if(theDuel == null)
        {
            throw new NotFoundException("Duel ID not found." + duelId);
        }

        return theDuel;
    }

    @PostMapping("/duels")
    public Duel addDuel(@RequestBody Duel theDuel)
    {
        theDuel.setId(0);

        Duel dbDuel = duelService.save(theDuel);

        return dbDuel;
    }

    @PutMapping("/duels")
    public Duel updateDeck(@RequestBody Duel theDuel)
    {
        Duel dbDuel = duelService.save(theDuel);

        return dbDuel;
    }

    @DeleteMapping("/duels/{duelId}")
    public String deleteDuel(@PathVariable int duelId)
    {
        Duel tempDuel = duelService.findById(duelId);

        if(tempDuel == null)
        {
            throw new NotFoundException("Duel id not found - " + duelId);
        }

        duelService.deleteById(duelId);

        return "Deleted duel with id - " + duelId;
    }
}
