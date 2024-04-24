package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ingresso;
import com.example.demo.entity.Utente;

import java.util.List;


@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Integer>{
    Optional<Ingresso> findById(int id);
    List<Ingresso> findAllByOrderByIdDesc();
    List<Optional<Ingresso>> findByUtente(Utente utente);
}
