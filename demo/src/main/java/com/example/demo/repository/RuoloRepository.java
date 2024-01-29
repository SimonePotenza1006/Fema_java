package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer>{
	Optional<Ruolo> findById(Long id);
}
