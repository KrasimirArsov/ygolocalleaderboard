package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.DAO;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SetCardService implements CRUDService<SetCard>
{
    public DAO<SetCard> deckCardDAO;

    @Autowired
    public SetCardService(DAO<SetCard> theDeckCardDAO)
    {
        deckCardDAO = theDeckCardDAO;
    }

    @Override
    public List<SetCard> findAll() {
        return deckCardDAO.findAll();
    }

    @Override
    public SetCard findById(int theId) {
        return deckCardDAO.findById(theId);
    }

    @Transactional
    @Override
    public SetCard save(SetCard theDeckCard) {
        return deckCardDAO.save(theDeckCard);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        deckCardDAO.deleteById(theId);
    }
}
