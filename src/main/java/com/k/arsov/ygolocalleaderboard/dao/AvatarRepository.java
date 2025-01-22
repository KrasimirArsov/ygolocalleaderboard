package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Avatar;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AvatarRepository
{
    private EntityManager entityManager;

    @Autowired
    public AvatarRepository(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }

    public void delete(Avatar theAvatar) {

        entityManager.remove(theAvatar);
    }
}
