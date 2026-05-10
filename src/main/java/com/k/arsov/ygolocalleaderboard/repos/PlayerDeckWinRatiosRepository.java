package com.k.arsov.ygolocalleaderboard.repos;

import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRatio;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerDeckWinRatioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "player-deck-win-ratios")
public interface PlayerDeckWinRatiosRepository extends JpaRepository<PlayerDeckWinRatio, PlayerDeckWinRatioId> {

    // Find all records for a specific player
    List<PlayerDeckWinRatio> findByPlayerId(int playerId);

    // Find all records for a specific deck
    List<PlayerDeckWinRatio> findByDeckId(int deckId);

    // Find a specific player's win rate with a specific deck
    PlayerDeckWinRatio findByPlayerIdAndDeckId(int playerId, int deckId);
}