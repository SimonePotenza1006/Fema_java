package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fornitore;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.OrdinePerIntervento;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Utente;


@Repository
public interface OrdinePerInterventoRepository extends JpaRepository<OrdinePerIntervento, Integer>{
    Optional<OrdinePerIntervento> findById(int id);
    List<Optional<OrdinePerIntervento>> findByUtente(Utente utente);
    List<Optional<OrdinePerIntervento>> findByIntervento(Intervento intervento);
}
