package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.CategoriaInterventoSpecifico;

@Repository
public interface CategoriaInterventoSpecificoRepository extends JpaRepository<CategoriaInterventoSpecifico, Integer>{
    Optional<CategoriaInterventoSpecifico> findById(int id);
    List<Optional<CategoriaInterventoSpecifico>> findByTipologiaIntervento(TipologiaIntervento tipologiaIntervento);
}
