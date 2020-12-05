package org.example.repositories;

import org.example.entities.AdoptersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptersRepository extends JpaRepository<AdoptersEntity, Integer> {

    @Query("from AdoptersEntity where user.username = ?1")
    AdoptersEntity getIdByUsername(String username);
}
