package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DuelDAO;
import com.k.arsov.ygolocalleaderboard.entity.Duel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DuelService implements CRUDService<Duel>
{
    public DuelDAO duelDAO;

    @Autowired
    public DuelService(DuelDAO theDuelDAO)
    {
        duelDAO = theDuelDAO;
    }

    @Override
    public List<Duel> findAll() {
        return duelDAO.findAll();
    }

    @Override
    public Duel findById(int theId) {
        return duelDAO.findById(theId);
    }

    @Transactional
    @Override
    public Duel save(Duel theDuel) {
        return duelDAO.save(theDuel);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        duelDAO.deleteById(theId);
    }

    public List<Duel> findMostRecent(int numMostRecent)
    {
        List<Duel> recentDuels = duelDAO.findAll();

        return recentDuels.subList(0, Math.min(numMostRecent, recentDuels.size()));
    }
}
