package com.k.arsov.ygolocalleaderboard.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k.arsov.ygolocalleaderboard.dao.SetCardDAO;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

@Service
public class CopySetCardService
{

    @Autowired
    private SetCardDAO cardSetRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public void fetchAndSaveSetCard(String setName) {
        String url = "https://db.ygoprodeck.com/api/v7/cardsetsinfo.php?setcode=" + setName;
        String response = restTemplate.getForObject(url, String.class);

        System.out.println(response);

        try {
            SetCard cardSet = objectMapper.readValue(response, SetCard.class);

            System.out.println(cardSet.getSetCode());
            System.out.println(cardSet.getSetPrice());
            System.out.println(cardSet.getSetRarity());
            System.out.println(cardSet.getSetName());
            System.out.println(cardSet);

            cardSetRepository.save(cardSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
