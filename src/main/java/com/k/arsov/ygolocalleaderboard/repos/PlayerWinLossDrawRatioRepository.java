package com.k.arsov.ygolocalleaderboard.repos;

import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerWinLossDrawRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "player-ratios", exported = true)
public interface PlayerWinLossDrawRatioRepository extends JpaRepository<PlayerWinLossDrawRatio, Long> {

    @Override
    @RestResource(exported = false)
    <S extends PlayerWinLossDrawRatio> S save(S entity);

    @Override
    @RestResource(exported = false)
    void delete(PlayerWinLossDrawRatio entity);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
}