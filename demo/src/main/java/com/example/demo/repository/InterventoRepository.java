package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;


@Repository
public interface InterventoRepository extends JpaRepository<Intervento, Integer>{
    List<Intervento> findAllByOrderByIdDesc();
    List<Optional<Intervento>> findByUtente(Utente utente);
    List<Optional<Intervento>> findByCliente(Cliente cliente);
    List<Optional<Intervento>> findByTipologia(TipologiaIntervento tipologiaIntervento);
}