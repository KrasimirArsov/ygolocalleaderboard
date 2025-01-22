package com.k.arsov.ygolocalleaderboard.dao;

import com.k.arsov.ygolocalleaderboard.entity.Avatar;
import com.k.arsov.ygolocalleaderboard.entity.Player;
import com.k.arsov.ygolocalleaderboard.entity.SetCard;
import com.k.arsov.ygolocalleaderboard.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// extends JpaRepository<User, Long>
public interface UserRepository{
    Optional<User> findByUsername(String username);

    //private EntityManager entityManager;

//    @Autowired
//    public UserRepository(EntityManager theEntityManager)
//    {
//        entityManager = theEntityManager;
//    }
//
//    public User findById(int theId) {
//        User theUser = entityManager.find(User.class, theId);
//
//        return theUser;
//    }
//
//    public List<User> findAll() {
//        //create query
//        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
//
//        //execute query
//        List<User> users = theQuery.getResultList();
//
//        //return
//        return users;
//    }

//    public User findByUsername(String theUsername) {
//        //create query
//        TypedQuery<User> theQuery = entityManager.createQuery("from User where username='" + theUsername + "'", User.class);
//
//        User theUser = theQuery.getResultList().get(0);
//
//        return theUser;
//    }
}
