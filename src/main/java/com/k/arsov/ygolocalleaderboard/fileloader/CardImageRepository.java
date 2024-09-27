package com.k.arsov.ygolocalleaderboard.fileloader;

import com.k.arsov.ygolocalleaderboard.entity.CardImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardImageRepository extends JpaRepository<CardImage, String> {
}