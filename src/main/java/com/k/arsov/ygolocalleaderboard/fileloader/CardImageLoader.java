package com.k.arsov.ygolocalleaderboard.fileloader;

import com.k.arsov.ygolocalleaderboard.entity.CardImage;
import com.k.arsov.ygolocalleaderboard.entity.EffectiveCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CardImageLoader {

    @Autowired
    private CardImageRepository cardImageRepository;

    @Autowired
    private EffectiveCardRepository effectiveCardRepository;

    @Transactional
    public void loadCardImagesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Process each line in the file
            while ((line = br.readLine()) != null) {
                // Find the last occurrence of " - "
                int lastDashIndex = line.lastIndexOf(" - ");

                if (lastDashIndex == -1) {
                    continue; // Skip invalid lines without " - "
                }

                String cardName = line.substring(0, lastDashIndex).trim();  // Effective card name
                String[] imageIds = line.substring(lastDashIndex + 3).split(",");  // Comma-separated image ids

                // Find the effective card in the database
                EffectiveCard effectiveCard = effectiveCardRepository.findByName(cardName);

                if (effectiveCard == null) {
                    System.err.println("Effective card not found: " + cardName);
                    continue;
                }

                // Insert images into the card_image table
                for (int i = 0; i < imageIds.length; i++) {
                    String imageId = imageIds[i].trim();

                    // Create new CardImage object
                    CardImage cardImage = new CardImage();
                    cardImage.setId(imageId);
                    cardImage.setArtwork(i + 1);  // Artwork starts from 1
                    cardImage.setEffectiveCard(effectiveCard);  // Associate with the EffectiveCard

                    // Save the CardImage object to the database
                    cardImageRepository.save(cardImage);
                }
            }

            System.out.println("Card images loaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
