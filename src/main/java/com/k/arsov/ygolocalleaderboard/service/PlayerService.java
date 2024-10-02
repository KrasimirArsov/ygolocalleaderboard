package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.PlayerDAO;
import com.k.arsov.ygolocalleaderboard.dto.DeckDTO;
import com.k.arsov.ygolocalleaderboard.dto.PlayerDTO;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.sqlviewentities.PlayerWinLossDrawRatio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class PlayerService implements CRUDService<Player>
{
    public PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO thePlayerDAO)
    {
        playerDAO = thePlayerDAO;
    }

    @Override
    public List<Player> findAll() {
        return playerDAO.findAll();
    }

    @Override
    public Player findById(int theId) {
        return playerDAO.findById(theId);
    }

    @Transactional
    @Override
    public Player save(Player thePlayer) {
        return playerDAO.save(thePlayer);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        playerDAO.deleteById(theId);
    }

    public List<PlayerWinLossDrawRatio> findAllPlayerWinLossDrawRatio() {
        return playerDAO.findAllWinLossDrawRatio();
    }

    public PlayerWinLossDrawRatio findByIdIdWinLossDrawRatio(int theId) {
        return playerDAO.findByIdWinLossDrawRatio(theId);
    }

    public List<PlayerWinLossDrawRatio> findTopPlayerWinLossDrawRatio(int numOfTopPlayersWinLossDrawRatios) {
        List<PlayerWinLossDrawRatio> returnList = playerDAO.findAllWinLossDrawRatio();

        return returnList.subList(0, Math.min(numOfTopPlayersWinLossDrawRatios, returnList.size()));
    }

    public PlayerDTO getPlayerDTOById(int theId)
    {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayer(playerDAO.findById(theId));
        playerDTO.setPlayerWinLossDrawRatio(playerDAO.findByIdWinLossDrawRatio(theId));
        playerDTO.setPlayerDeckWinRates(playerDAO.findAllPlayerDeckWinRateByPlayerId(theId));

        return playerDTO;
    }

    public PlayerDTO getPlayerDTOByName(String theName)
    {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayer(playerDAO.findByName(theName));
        playerDTO.setPlayerWinLossDrawRatio(playerDAO.findByIdWinLossDrawRatio(playerDTO.getPlayer().getId()));
        playerDTO.setPlayerDeckWinRates(playerDAO.findAllPlayerDeckWinRateByPlayerId(playerDTO.getPlayer().getId()));

        return playerDTO;
    }

    public List<PlayerDTO> getAllPlayerDTOs()
    {
        List<PlayerDTO> playerDTOs = new ArrayList<>();

        for(Player player : findAll())
        {
            playerDTOs.add(getPlayerDTOById(player.getId()));
        }

        return playerDTOs;
    }

    public Map<Integer,Player> getAllPlayersAsMap()
    {
        return findAll().stream()
                .collect(Collectors.toMap(Player::getId, player -> player));
    }
}
