package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRatio;
import com.k.arsov.ygolocalleaderboard.repos.PlayerDeckWinRatiosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player-deck-win-ratios")
public class PlayerDeckWinRatioController {

    private final PlayerDeckWinRatiosRepository repository;

    public PlayerDeckWinRatioController(PlayerDeckWinRatiosRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PlayerDeckWinRatio> getAll() {
        return repository.findAll();
    }
}