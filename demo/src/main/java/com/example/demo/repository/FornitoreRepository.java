package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.Ruolo;

@Repository
public interface FornitoreRepository extends JpaRepository<Fornitore, Integer>{
    Optional<Fornitore> findById(int id);
}
