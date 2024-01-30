package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Veicolo;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Integer> {
    Optional<Veicolo> findById(int id);
}
