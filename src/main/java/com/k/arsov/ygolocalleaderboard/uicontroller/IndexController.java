package com.k.arsov.ygolocalleaderboard.uicontroller;

import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.DeckWinLossDrawRatio;
import com.k.arsov.ygolocalleaderboard.entity.Duel;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerWinLossDrawRatio;
import com.k.arsov.ygolocalleaderboard.service.DeckService;
import com.k.arsov.ygolocalleaderboard.service.DuelService;
import com.k.arsov.ygolocalleaderboard.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController
{

    @Autowired
    private DeckService deckService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private DuelService duelService;

    @GetMapping("/home")
    public String displayHomePage(Model model) {
        List<DeckWinLossDrawRatio> deckWLDRatios = deckService.findTopDeckWinLossDrawRatio(3);
        model.addAttribute("deckWLDRatios", deckWLDRatios);

        List<PlayerWinLossDrawRatio> playerWLDRatios = playerService.findTopPlayerWinLossDrawRatio(3);
        model.addAttribute("playerWLDRatios", playerWLDRatios);

        List<Duel> mostRecentDuels = duelService.findMostRecent(5);
        model.addAttribute("duels", mostRecentDuels);

        return "index";
    }
}
