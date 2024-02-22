package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;


@Transactional
@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Integer>{
    
    Optional<Immagine> findByName (String name);
    List<Immagine> findAll();
    Optional<Immagine> findByIntervento(Intervento intervento);
}
