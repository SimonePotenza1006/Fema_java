package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attivita;

@Repository
public interface AttivitaRepository extends JpaRepository<Attivita, Integer>  {
    Optional<Attivita> findById(int id);
}
