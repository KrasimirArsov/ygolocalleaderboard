package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DAO;
import com.k.arsov.ygolocalleaderboard.entity.Duel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DuelServiceImpl implements CRUDService<Duel>
{
    public DAO<Duel> duelDAO;

    @Autowired
    public DuelServiceImpl(DAO<Duel> theDuelDAO)
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
}
