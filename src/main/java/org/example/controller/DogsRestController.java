package org.example.controller;

import org.example.entities.DogsEntity;
import org.example.repositories.DogsRepository;
import org.example.services.DogsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogsRestController {
    private static final Logger log = LoggerFactory.getLogger(DogsAppController.class);

    public DogsRestController() {
        log.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private DogsServices dogsServices;


}
