package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ImageData;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;

@Transactional
@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Long>{
    Optional<ImageData> findByName(String name);
	List<ImageData> findAll();
	List<ImageData> findByTipofoto(String tipofoto);
	Optional<ImageData> findByTipofotoAndUtente(String tipofoto, Utente utente);
}
