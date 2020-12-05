package org.example.services;

import org.example.entities.AdoptersEntity;
import org.example.entities.AdoptionsEntity;
import org.example.entities.DogsEntity;
import org.example.repositories.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;


    public AdoptionsEntity getAdoptionById(Integer id){
        return adoptionRepository.getOne(id);
    }

    public void saveAdoption(AdoptionsEntity adoptionsEntity){
        adoptionRepository.save(adoptionsEntity);
    }

    public List<AdoptionsEntity> getAllAdoptions(Integer id){
        return adoptionRepository.getAllAdoptions(id);
    }

    public List<AdoptionsEntity> getAllAdoptionsByUsername(String username){
        return adoptionRepository.getAllAdoptionsByUsername(username);
    }







}
