package org.example.repositories;

import org.example.entities.DogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDogsRepository extends JpaRepository<DogsEntity,Integer> {
    List<DogsEntity> findAll();
}
