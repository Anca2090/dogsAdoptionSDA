package org.example.repositories;

import org.example.entities.AdoptersEntity;
import org.example.entities.AdoptionsEntity;
import org.example.entities.DogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<AdoptionsEntity, Integer> {

    @Query("FROM AdoptionsEntity where adopter.adopterId = ?1 order by adoptionDate")
    List<AdoptionsEntity> getAllAdoptions(Integer Id);

    @Query("FROM AdoptionsEntity where adopter.user.username = ?1 order by adoptionDate")
    List<AdoptionsEntity> getAllAdoptionsByUsername(String username);




}
