package com.k.arsov.ygolocalleaderboard.repos;

import com.k.arsov.ygolocalleaderboard.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeckRepository extends JpaRepository<Deck, Long> {
}
