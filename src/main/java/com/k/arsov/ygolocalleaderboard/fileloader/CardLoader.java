package com.k.arsov.ygolocalleaderboard.fileloader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k.arsov.ygolocalleaderboard.entity.EffectiveCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardLoader {

    @Autowired
    private EffectiveCardRepository cardRepository;

    @Transactional
    public void loadCardsFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            List<EffectiveCard> cards = new ArrayList<>();

            // Iterate over the array of cards in the JSON file
            for (JsonNode cardNode : rootNode) {
                EffectiveCard card = new EffectiveCard();

                // Set the fields from JSON, checking for null values
                card.setName(getStringValue(cardNode, "name"));
                card.setType(getStringValue(cardNode, "type"));
                card.setDescription(getStringValue(cardNode, "desc"));
                card.setRace(getStringValue(cardNode, "race"));
                card.setAtk(getIntValue(cardNode, "atk"));
                card.setDef(getIntValue(cardNode, "def"));
                card.setLevel(getIntValue(cardNode, "level"));
                card.setAttribute(getStringValue(cardNode, "attribute"));

                // Add the card to the list
                cards.add(card);
            }

            // Save all cards in the database
            cardRepository.saveAll(cards);
            System.out.println("Cards inserted successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper methods to safely retrieve values

    private String getStringValue(JsonNode node, String fieldName) {
        JsonNode valueNode = node.get(fieldName);
        return (valueNode != null && !valueNode.isNull()) ? valueNode.asText() : null;
    }

    private Integer getIntValue(JsonNode node, String fieldName) {
        JsonNode valueNode = node.get(fieldName);
        return (valueNode != null && !valueNode.isNull()) ? valueNode.asInt() : null;
    }
}
