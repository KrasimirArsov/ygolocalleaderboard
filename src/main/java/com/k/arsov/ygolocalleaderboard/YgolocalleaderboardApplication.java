package com.k.arsov.ygolocalleaderboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YgolocalleaderboardApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(YgolocalleaderboardApplication.class, args);
	}


//	@Autowired
//	private CopySetCardService setCardService;
//
//	@Bean
//	public CommandLineRunner commandLineRunner(PlayerDAO playerDAO, DuelDAO duelDAO, DeckDAO deckDAO)
//	{
//		return runner ->{
//			customMain();
//		};
//	}
//
//	private void customMain() {
//
//		setCardService.fetchAndSaveSetCard("LCGX-EN002");
//
//	}
}
