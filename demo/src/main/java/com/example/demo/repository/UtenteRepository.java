package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Ruolo;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{
    Utente findByEmail(String email);
    List<Utente> findByRuolo(Ruolo ruolo);
    List<Utente> findByAttivoTrue();
}
