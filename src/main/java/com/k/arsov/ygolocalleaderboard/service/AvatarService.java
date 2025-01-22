package com.k.arsov.ygolocalleaderboard.service;

import com.k.arsov.ygolocalleaderboard.dao.AvatarRepository;
import com.k.arsov.ygolocalleaderboard.entity.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    public void delete(Avatar avatar) {
        avatarRepository.delete(avatar);
    }
}
