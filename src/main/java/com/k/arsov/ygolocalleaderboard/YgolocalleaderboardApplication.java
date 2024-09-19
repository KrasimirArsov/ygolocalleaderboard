package com.k.arsov.ygolocalleaderboard;

import com.k.arsov.ygolocalleaderboard.dao.DeckDAO;
import com.k.arsov.ygolocalleaderboard.dao.DuelDAO;
import com.k.arsov.ygolocalleaderboard.dao.PlayerDAO;
import com.k.arsov.ygolocalleaderboard.entity.Deck;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YgolocalleaderboardApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(YgolocalleaderboardApplication.class, args);
	}

}
