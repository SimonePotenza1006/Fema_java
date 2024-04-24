package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Ddt;
import com.example.demo.entity.RelazioneUtentiProdotti;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RelazioneUtentiProdottiRepository extends JpaRepository<RelazioneUtentiProdotti, Integer>{
    Optional<RelazioneUtentiProdotti> findById(int id);
    List<Optional<RelazioneUtentiProdotti>> findByUtente(Utente utente);
    List<Optional<RelazioneUtentiProdotti>> findByProdotto(Prodotto prodotto);
    List<Optional<RelazioneUtentiProdotti>> findByDdt(Ddt ddt);
    List<Optional<RelazioneUtentiProdotti>> findByMateriale(String materiale);
}
