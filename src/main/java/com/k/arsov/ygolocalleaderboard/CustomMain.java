package com.k.arsov.ygolocalleaderboard;

import com.k.arsov.ygolocalleaderboard.fileloader.CardImageLoader;
import com.k.arsov.ygolocalleaderboard.fileloader.CardLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CustomMain implements CommandLineRunner {

    @Autowired
    private CardLoader cardLoader;
    @Autowired
    private CardImageLoader cardImageLoader;

    public static void main(String[] args) {
        SpringApplication.run(CustomMain.class, args);
    }

    @Override
    public void run(String... args) {
        // Provide the path to your JSON file
        //cardLoader.loadCardsFromJson("src/main/resources/manual/cards.json");
        cardImageLoader.loadCardImagesFromFile("src/main/resources/manual/allCardsPlusImages.txt");
    }
}
