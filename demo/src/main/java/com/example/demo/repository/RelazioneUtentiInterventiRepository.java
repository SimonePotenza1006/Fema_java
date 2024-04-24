package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.RelazioneUtentiInterventi;
import com.example.demo.entity.Utente;

@Repository
public interface RelazioneUtentiInterventiRepository extends JpaRepository<RelazioneUtentiInterventi, Integer>{
    Optional<RelazioneUtentiInterventi> findById(int id);
    List<Optional<RelazioneUtentiInterventi>> findByUtente(Utente utente);
    List<Optional<RelazioneUtentiInterventi>> findByIntervento(Intervento intervento);
}
