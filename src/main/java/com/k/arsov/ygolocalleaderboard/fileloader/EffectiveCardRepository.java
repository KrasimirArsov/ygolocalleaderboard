package com.k.arsov.ygolocalleaderboard.fileloader;

import com.k.arsov.ygolocalleaderboard.entity.EffectiveCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectiveCardRepository extends JpaRepository<EffectiveCard, String> {
    EffectiveCard findByName(String name);
}