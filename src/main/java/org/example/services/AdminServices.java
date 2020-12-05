package org.example.services;

import org.example.entities.AdoptersEntity;
import org.example.entities.DogsEntity;
import org.example.repositories.AdminDogsRepository;
import org.example.repositories.AdoptersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    private static final Logger log = LoggerFactory.getLogger(AdminServices.class);

    public AdminServices() {
        log.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    AdminDogsRepository adminDogsRepository;

    @Autowired
    AdoptersRepository adoptersRepository;

    public DogsEntity getDog(Integer id){

        return adminDogsRepository.getOne(id);
    }

    public List<DogsEntity> getAllDogs(){
        return adminDogsRepository.findAll();
    }


    public void saveDog(DogsEntity dogsEntity){
        adminDogsRepository.save(dogsEntity);
    }

    public void deleteDog(Integer id){
        DogsEntity dogsEntity = adminDogsRepository.getOne(id);
        dogsEntity.setDeleted(true);
        adminDogsRepository.save(dogsEntity);
    }




}
