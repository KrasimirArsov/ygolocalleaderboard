package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.SetCardDAO;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SetCardService implements CRUDService<SetCard>
{
    public SetCardDAO setCardDAO;

    @Autowired
    public SetCardService(SetCardDAO theSetCardDAO)
    {
        setCardDAO = theSetCardDAO;
    }

    @Override
    public List<SetCard> findAll() {
        return setCardDAO.findAll();
    }

    @Override
    public SetCard findById(int theId) {
        return setCardDAO.findById(theId);
    }

    @Transactional
    @Override
    public SetCard save(SetCard theSetCard) {
        return setCardDAO.save(theSetCard);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        setCardDAO.deleteById(theId);
    }
}
