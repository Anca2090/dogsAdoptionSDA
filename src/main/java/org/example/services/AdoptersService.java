package org.example.services;

import org.example.controller.DogsAppController;
import org.example.entities.AdoptersEntity;
import org.example.entities.User;
import org.example.repositories.AdoptersRepository;
import org.example.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptersService {

    private static final Logger log = LoggerFactory.getLogger(DogsAppController.class);

    public AdoptersService() {
        log.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private AdoptersRepository adoptersRepository;
    @Autowired
    private UserRepository userRepository;


    public AdoptersEntity getAdopter(Integer id) {
        return adoptersRepository.getOne(id);
    }

    public List<User> getAllAdopters(){
        return userRepository.getUsersList("ADOPTER");
    }


    public void delete(String id){
        User user = userRepository.getOne(id);
        user.setEnabled(false);
        user.setDeleted(true);
        userRepository.save(user);
    }
}

