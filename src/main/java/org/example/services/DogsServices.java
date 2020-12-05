package org.example.services;

import org.example.controller.DogsAppController;
import org.example.entities.DogsEntity;
import org.example.repositories.AdoptionRepository;
import org.example.repositories.DogsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogsServices {

    private static final Logger log = LoggerFactory.getLogger(DogsAppController.class);

    @Autowired
    private DogsRepository dogsRepository;

    @Autowired
    private AdoptionRepository adoptionRepository;

    public DogsServices() {
        log.info(getClass().getSimpleName() + " created");
    }

    public List<DogsEntity> getAllDogs(){

        return dogsRepository.findAllByAdoptedFalse();
    }



//    public void saveDog(DogsEntity dogsEntity){
//        dogsRepository.save(dogsEntity);
//    }

    public void adoptedDog(Integer id) {
        DogsEntity dogsEntity = dogsRepository.getOne(id);
        dogsEntity.setAdopted(true);
        dogsRepository.save(dogsEntity);
    }



    public DogsEntity getDescription(Integer id){
        DogsEntity dogsEntity = dogsRepository.getOne(id);
        dogsEntity.getDescription();
        return dogsEntity;
    }

    public DogsEntity getImages(Integer id){
        DogsEntity dogsEntity = dogsRepository.getOne(id);
        dogsEntity.getImageUrl();
        return dogsEntity;
    }

    public DogsEntity getAllDogsByNumber(Integer id){
        DogsEntity dogsEntity = dogsRepository.getOne(id);
        dogsEntity.getDogNumber();
        return dogsEntity;
    }

}
