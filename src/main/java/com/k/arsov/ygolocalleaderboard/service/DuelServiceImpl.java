package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DuelDAO;
import com.k.arsov.ygolocalleaderboard.entity.Duel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DuelServiceImpl implements DuelService
{
    public DuelDAO DuelDAO;

    @Autowired
    public DuelServiceImpl(DuelDAO theDuelDAO)
    {
        DuelDAO = theDuelDAO;
    }

    @Override
    public List<Duel> findAll() {
        return DuelDAO.findAll();
    }

    @Override
    public Duel findById(int theId) {
        return DuelDAO.findById(theId);
    }

    @Transactional
    @Override
    public Duel save(Duel theDuel) {
        return DuelDAO.save(theDuel);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        DuelDAO.deleteById(theId);
    }
}
