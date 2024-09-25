package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.service.CopySetCardService;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import com.k.arsov.ygolocalleaderboard.rest.exceptions.response.NotFoundException;
import com.k.arsov.ygolocalleaderboard.service.CRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class SetCardRESTController
{
    private static final Logger logger = LoggerFactory.getLogger(SetCardRESTController.class);
    private CRUDService<SetCard> deckCardService;
    private CopySetCardService copySetCardService;

    @Autowired
    public SetCardRESTController(CRUDService<SetCard> theDeckCardService, CopySetCardService theCopySetCardService)
    {
        deckCardService = theDeckCardService;
        copySetCardService = theCopySetCardService;
    }


    @GetMapping("/set-cards")
    public List<SetCard> findAll()
    {
        return deckCardService.findAll();
    }

    @GetMapping("/set-cards-fetch-and-save-from-external-source")
    public String fetchAndSaveExternal() throws FileNotFoundException
    {
        Scanner scan = new Scanner(new BufferedReader(new FileReader(new File("E:\\Dev\\git2\\ygolocalleaderboard\\src\\main\\resources\\manual\\allEnCards.txt"))));
        while(scan.hasNextLine())
        {
            try
            {
                copySetCardService.fetchAndSaveSetCard(scan.nextLine());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        return "d";
    }


    @GetMapping("/set-cards/{deckCardId}")
    public SetCard getDeckCard(@PathVariable int deckCardId)
    {
        SetCard theDeckCard = deckCardService.findById(deckCardId);

        if(theDeckCard == null)
        {
            throw new NotFoundException("DeckCard ID not found." + deckCardId);
        }

        return theDeckCard;
    }

    @PutMapping("/set-cards")
    public SetCard updateDeckCard(@RequestBody SetCard theDeckCard)
    {
        SetCard dbPlayer = deckCardService.save(theDeckCard);

        return dbPlayer;
    }

    @DeleteMapping("/set-cards/{deckCardId}")
    public String deleteDeckCard(@PathVariable int deckCardId)
    {
        SetCard tempDeckCard = deckCardService.findById(deckCardId);

        if(tempDeckCard == null)
        {
            throw new NotFoundException("DeckCard id not found - " + deckCardId);
        }

        deckCardService.deleteById(deckCardId);

        return "Deleted DeckCard with id - " + deckCardId;
    }
}
