package com.k.arsov.ygolocalleaderboard.repos;

import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.DeckWinLossDrawRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "deck-ratios", exported = true)
public interface DeckWinLossDrawRatioRepository extends JpaRepository<DeckWinLossDrawRatio, Long> {

    @Override
    @RestResource(exported = false)
    <S extends DeckWinLossDrawRatio> S save(S entity);

    @Override
    @RestResource(exported = false)
    void delete(DeckWinLossDrawRatio entity);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
}
