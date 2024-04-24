package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.TipologiaIntervento;

import java.util.List;

public interface SopralluogoRepository extends JpaRepository<Sopralluogo, Integer>{
    List<Sopralluogo> findAllByOrderByIdDesc();
    List<Optional<Sopralluogo>> findByUtente(Utente utente);
    List<Optional<Sopralluogo>> findByCliente(Cliente cliente);
    List<Optional<Sopralluogo>> findByTipologia(TipologiaIntervento tipologia);
}
