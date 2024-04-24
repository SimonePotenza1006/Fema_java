package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.TipologiaSpesaVeicolo;

@Repository
public interface TipologiaSpesaVeicoloRepository extends JpaRepository<TipologiaSpesaVeicolo, Integer>{
    Optional<TipologiaSpesaVeicolo> findById(int id);
}
