package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.RestituzioneMerce;
import com.example.demo.entity.Utente;

@Repository
public interface RestituzioneMerceRepository extends JpaRepository<RestituzioneMerce, Integer>{
    List<RestituzioneMerce> findAllByOrderByIdDesc();
    List<RestituzioneMerce> findByFornitore(Fornitore fornitore);
    List<RestituzioneMerce> findByUtenteRiconsegna(Utente utente_riconsegna);    
    List<RestituzioneMerce> findByUtenteRitiro(Utente utente_ritiro);
}
