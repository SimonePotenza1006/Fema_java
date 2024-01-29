package com.example.demo.repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TipologiaCarta;
import com.example.demo.entity.Utente;
import com.example.demo.entity.CartaDiCredito;
import com.example.demo.entity.Ruolo;



@Repository
public interface TipologiaCartaRepository extends JpaRepository<TipologiaCarta, Integer> {
    Optional<TipologiaCarta> findById(int id);
}
